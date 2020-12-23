package io.github.matrix.codewars.flink;

import io.github.matrix.flink.RandomData;
import io.github.matrix.flink.RandomStringSource;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * TODO Actor、Reactor、Proactor
 *
 * @author Noa Swartz
 * @date 2020/12/23
 */
public class WindowTest {

    @Test
    public void testWindow() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataStream<String> stream = env.addSource(new RandomStringSource());
        DataStream<RandomData> dataStream = stream.map(value -> {
            RandomData data = new RandomData();
            String[] fields = value.split(RandomStringSource.DELIMITER);
            data.setId(Integer.parseInt(fields[0]));
            data.setLength(Integer.parseInt(fields[1]));
            data.setData(fields[2]);
            data.setTimestamp(Long.parseLong(fields[3]));
            return data;
        });
        dataStream.keyBy(RandomData::getId)
                .timeWindow(Time.seconds(15))
                .aggregate(new AggregateFunction<RandomData, Integer, Integer>() {
                    @Override
                    public Integer createAccumulator() {
                        return 0;
                    }

                    @Override
                    public Integer add(RandomData value, Integer accumulator) {
                        return accumulator + 1;
                    }

                    @Override
                    public Integer getResult(Integer accumulator) {
                        return accumulator;
                    }

                    @Override
                    public Integer merge(Integer a, Integer b) {
                        return a + b;
                    }
                }).print();

        env.execute("CharCount Job");
    }

    @Test
    public void testWatermark() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataStream<String> stream = env.addSource(new RandomStringSource());
        DataStream<RandomData> dataStream = stream.map(value -> {
            RandomData data = new RandomData();
            String[] fields = value.split(RandomStringSource.DELIMITER);
            data.setId(Integer.parseInt(fields[0]));
            data.setLength(Integer.parseInt(fields[1]));
            data.setData(fields[2]);
            data.setTimestamp(Long.parseLong(fields[3]));
            return data;
        });

        OutputTag<RandomData> lateOutputTag = new OutputTag<>("late") {};
        SingleOutputStreamOperator<RandomData> minStream = dataStream.assignTimestampsAndWatermarks(WatermarkStrategy
                .<RandomData>forBoundedOutOfOrderness(Duration.ofSeconds(3))
                .withTimestampAssigner((element, recordTimestamp) -> element.getTimestamp() * 1000L))
                .keyBy(RandomData::getId)
                .timeWindow(Time.seconds(15))
                .allowedLateness(Time.minutes(1))
                .sideOutputLateData(lateOutputTag)
                .min("length");
        minStream.print("normal");
        minStream.getSideOutput(lateOutputTag).print("late");
        env.execute("CharCount Job");
    }

    @Test
    public void testState() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataStream<String> stream = env.addSource(new RandomStringSource());
        DataStream<RandomData> dataStream = stream.map(value -> {
            RandomData data = new RandomData();
            String[] fields = value.split(RandomStringSource.DELIMITER);
            data.setId(Integer.parseInt(fields[0]));
            data.setLength(Integer.parseInt(fields[1]));
            data.setData(fields[2]);
            data.setTimestamp(Long.parseLong(fields[3]));
            return data;
        });
        dataStream.keyBy(RandomData::getId)
                .flatMap(new LengthChangedWarning(3))
                .print();

        env.execute("CharCount Job");
    }

    static class LengthChangedWarning extends RichFlatMapFunction<RandomData, Tuple3<Integer, Integer, Integer>> {

        private Integer threshold;

        private ValueState<Integer> lastLenState;

        public LengthChangedWarning(Integer threshold) {
            this.threshold = threshold;
        }

        @Override
        public void open(Configuration parameters) throws Exception {
            lastLenState = getRuntimeContext().getState(new ValueStateDescriptor<Integer>("last-len", Integer.class));
        }

        @Override
        public void flatMap(RandomData value, Collector<Tuple3<Integer, Integer, Integer>> out) throws Exception {
            Integer lastLen = lastLenState.value();
            if (lastLen != null) {
                if (Math.abs(lastLen - value.getLength()) >= threshold) {
                    out.collect(new Tuple3<>(value.getId(), lastLen, value.getLength()));
                }
            }
            lastLenState.update(value.getLength());
        }

        @Override
        public void close() throws Exception {
            lastLenState.clear();
        }

    }

}
