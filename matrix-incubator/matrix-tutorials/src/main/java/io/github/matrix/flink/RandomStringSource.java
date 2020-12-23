package io.github.matrix.flink;

import com.google.common.base.Joiner;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.SplitStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoMapFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.*;

/**
 * @author Noa Swartz
 * @date 2020/12/23
 */
public class RandomStringSource implements SourceFunction<String> {

    public static final String DELIMITER = " ";
    private static final Random RANDOM = new Random();

    private final int batchSize;
    private boolean running;

    public RandomStringSource() {
        running = true;
        batchSize = 10;
    }

    @Override
    public void run(SourceContext<String> ctx) throws Exception {
        while (running) {
            for (int i = 0; i < batchSize; ++i) {
                String str = UUID.randomUUID().toString()
                        .replaceAll("(.)(?=.*\\1)", "")
                        .replace("-", "");
                ctx.collect(Joiner.on(DELIMITER).join(RANDOM.nextInt(50), str.length(), str, System.currentTimeMillis()));
            }
            Thread.sleep(3000L);
        }
    }

    @Override
    public void cancel() {
        running = false;
    }

    public static void reduce(SingleOutputStreamOperator<RandomData> map) {
        map.keyBy(RandomData::getId)
                .reduce((value1, value2) -> {
                    int len = Math.max(value1.getLength(), value2.getLength());
                    String data = value1.getLength() > value2.getLength() ? value1.getData() : value2.getData();
                    return new RandomData(value1.getId(), len, data, value2.getTimestamp());
                })
                .print();
    }

    public static void splitSelect(SingleOutputStreamOperator<RandomData> map) {
        // 分流
        SplitStream<RandomData> split = map.split(value -> Collections.singleton(value.getLength() > 13 ? "long" : "short"));
        DataStream<RandomData> longStream = split.select("long");
        DataStream<RandomData> shortStream = split.select("short");
        DataStream<RandomData> allStream = split.select("long", "short");
        longStream.print("long");
        shortStream.print("short");
        allStream.print("all");

        // 合流
        DataStream<Tuple2<Integer, Integer>> longMapStream = longStream.map(value -> new Tuple2<>(value.getId(), value.getLength()))
                .returns(TypeInformation.of(new TypeHint<>() {}));
        ConnectedStreams<Tuple2<Integer, Integer>, RandomData> connectedStreams = longMapStream.connect(shortStream);
        SingleOutputStreamOperator<Object> resultStream = connectedStreams.map(new CoMapFunction<>() {
            @Override
            public Object map1(Tuple2<Integer, Integer> value) {
                return new Tuple3<>(value.f0, value.f1, "string too long.");
            }

            @Override
            public Object map2(RandomData value) {
                return new Tuple3<>(value.getId(), value.getLength(), "string too short.");
            }
        });
        // 联合
        longStream.union(shortStream, allStream).map(RandomData::toString)
                .addSink(new FlinkKafkaProducer<String>("localhost:9092", "topic-flink-stream", new SimpleStringSchema()));
    }

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> stream = env.addSource(new RandomStringSource());
        SingleOutputStreamOperator<RandomData> map = stream.map(value -> {
            RandomData data = new RandomData();
            String[] fields = value.split(DELIMITER);
            data.setId(Integer.parseInt(fields[0]));
            data.setLength(Integer.parseInt(fields[1]));
            data.setData(fields[2]);
            data.setTimestamp(Long.parseLong(fields[3]));
            return data;
        });
        splitSelect(map);
        env.execute("CharCount Job");
    }

}
