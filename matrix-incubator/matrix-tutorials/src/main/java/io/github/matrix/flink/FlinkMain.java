package io.github.matrix.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @author Noa Swartz
 * @date 2020/12/22
 */
public class FlinkMain {

    public static void main(String[] args) throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        String path = "E:\\java\\github\\matrix\\matrix-incubator\\matrix-tutorials\\src\\main\\resources\\en-basic";
        DataSet<String> dataSource = env.readTextFile(path);
        DataSet<Tuple2<Character, Integer>> result = dataSource
                .flatMap(new CharCounterFlatMapper())
                .groupBy(0)
                .sum(1);
        result.print();
    }

    static class CharCounterFlatMapper implements FlatMapFunction<String, Tuple2<Character, Integer>> {

        @Override
        public void flatMap(String value, Collector<Tuple2<Character, Integer>> out) {
            char[] chars = value.toCharArray();
            for (char ch : chars) {
                out.collect(new Tuple2<>(ch, 1));
            }
        }

    }

}
