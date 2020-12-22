package io.github.matrix.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @author Noa Swartz
 * @date 2020/12/22
 */
public class CharCounterFlatMapper implements FlatMapFunction<String, Tuple2<Character, Integer>> {

    @Override
    public void flatMap(String value, Collector<Tuple2<Character, Integer>> out) {
        char[] chars = value.trim().toCharArray();
        for (char ch : chars) {
            out.collect(new Tuple2<>(ch, 1));
        }
    }

}