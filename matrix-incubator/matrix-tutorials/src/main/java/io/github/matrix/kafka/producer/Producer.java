package io.github.matrix.kafka.producer;

import io.github.matrix.kafka.KafkaHelper;
import io.github.matrix.kafka.partitions.CustomPartitioner;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Noa Swartz
 * @date 2020/12/07
 */
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    public static void main(String[] args) {
        Properties props = KafkaHelper.getProducerConfig();
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());
        try(KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < Integer.MAX_VALUE; ++i) {
                ProducerRecord<String, String> record = new ProducerRecord<>(KafkaHelper.TOPIC, "message " + i);
                Future<RecordMetadata> future = producer.send(record);
                RecordMetadata metadata = future.get();
                logger.info(metadata.topic() + "-" + metadata.partition() + ":" + metadata.offset());
                Thread.sleep(500L);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
