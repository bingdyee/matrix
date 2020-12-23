package io.github.matrix.flink;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

/**
 * @author Noa Swartz
 * @date 2020/12/23
 */
public class KafkaStreamCharCount {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "flink-stream");
        DataStream<String> stream = env
                .addSource(new FlinkKafkaConsumer<>("topic-flink-stream", new SimpleStringSchema(), properties));
        stream.flatMap(new CharCounterFlatMapper())
                .keyBy(value -> value.f0)
                .sum(1)
                .print();
        env.execute("CharCount Job");
    }

}
