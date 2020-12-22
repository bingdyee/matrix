package io.github.matrix.flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author Noa Swartz
 * @date 2020/12/22
 */
public class StreamCharCount {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        String path = "D:\\nltk_data\\corpora\\words\\en-basic";
        // DataStream<String> dataStream = env.readTextFile(path);
        DataStream<String> dataStream = env.socketTextStream("localhost", 8888);
        dataStream.flatMap(new CharCounterFlatMapper())
                .keyBy(value -> value.f0)
                .sum(1)
                .print();
        env.execute("Window WordCount");
    }

}
