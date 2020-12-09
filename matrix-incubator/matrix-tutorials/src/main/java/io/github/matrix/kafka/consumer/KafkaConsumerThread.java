package io.github.matrix.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Noa Swartz
 * @date 2020/12/08
 */
public class KafkaConsumerThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerThread.class);

    private final KafkaConsumer<String, String> kafkaConsumer;
    private final ExecutorService executorService;

    public KafkaConsumerThread(Properties props, String topic, int threadNumber) {
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, ConsumerTTLInterceptor.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        kafkaConsumer = new KafkaConsumer<>(props);
        kafkaConsumer.subscribe(Collections.singletonList(topic));
        executorService = new ThreadPoolExecutor(threadNumber, threadNumber, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1000), new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "records-handler-" + threadNumber.getAndIncrement());
            }
        }, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Override
    public void run() {
        try {
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
                if (!records.isEmpty()) {
                    executorService.execute(new RecordsHandler(records));
                }
            }
        } finally {
            kafkaConsumer.close();
        }
    }

    static class RecordsHandler implements Runnable {

        private final ConsumerRecords<String, String> records;

        public RecordsHandler(ConsumerRecords<String, String> records) {
            this.records = records;
        }

        @Override
        public void run() {
            records.forEach(record -> logger.info("[" + record.topic() + "-" + record.partition() + ":" + record.offset() + "] - " + record.value()));
        }

    }

}
