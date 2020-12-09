package io.github.matrix.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 *
 * kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic-matrix
 *
 * kafka-topics.bat --list --zookeeper 127.0.0.1:2181
 *
 * kafka-console-producer.bat --broker-list 127.0.0.1:9092 --topic topic-matrix
 *
 * kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic topic-matrix --from-beginning
 *
 * kafka-topics --zookeeper 127.0.0.1:2181 --alter --topic topic-matrix --partitions 3
 *
 * @author Noa Swartz
 * @date 2020/12/07
 */
public final class KafkaHelper {

    public static final String BROKERS = "127.0.0.1:9092";

    public static final String TOPIC = "topic-matrix";

    public static final String GROUP_ID = "group.matrix";

    public static Properties getConsumerConfig() {
        Properties props = new Properties();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaHelper.BROKERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaHelper.GROUP_ID);
        return props;
    }

    public static Properties getProducerConfig() {
        Properties props = new Properties();
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaHelper.BROKERS);
        return props;
    }

    private KafkaHelper() { }

}
