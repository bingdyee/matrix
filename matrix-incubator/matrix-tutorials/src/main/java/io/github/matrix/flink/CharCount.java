package io.github.matrix.flink;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

/**
 * @author Noa Swartz
 * @date 2020/12/22
 */
public class CharCount {

    public static void main(String[] args) throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        String path = "D:\\nltk_data\\corpora\\words\\en-basic";
        DataSet<String> dataSource = env.readTextFile(path);
        dataSource.flatMap(new CharCounterFlatMapper())
                .groupBy(0)
                .sum(1)
                .print();
    }

}
