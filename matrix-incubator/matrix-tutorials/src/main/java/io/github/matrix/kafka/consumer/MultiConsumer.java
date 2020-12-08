package io.github.matrix.kafka.consumer;

import io.github.matrix.kafka.KafkaHelper;

import java.util.Properties;

/**
 * @author Noa Swartz
 * @date 2020/12/07
 */
public class MultiConsumer {

    public static void main(String[] args) {
        Properties props = KafkaHelper.getConsumerConfig();
        new KafkaConsumerThread(props, KafkaHelper.TOPIC,
                Runtime.getRuntime().availableProcessors()).start();

    }

}
