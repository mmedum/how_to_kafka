package com.mmedum.howtokafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageConsumer {

    private static final Logger LOGGER = Logger.getLogger(MessageConsumer.class.getName());

    private final static String TOPIC = "test-topic";
    private final static String SERVERS = "localhost:9092";


    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Starting up");
        MessageConsumer consumer = new MessageConsumer();
        consumer.runMessageConsumer();
    }

    private Consumer<Long, String> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "MessageConsumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        final Consumer<Long, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(TOPIC));
        return consumer;
    }

    private void runMessageConsumer(){
        final Consumer<Long, String> consumer = createConsumer();
        int noRecordsCount = 0;

        while (true) {
            final ConsumerRecords<Long, String> consumerRecords =
                    consumer.poll(1000);

            consumerRecords.forEach(record -> {
                LOGGER.info("Consumer Record: (" + record.key() + ", " + record.value() +
                                ", " + record.partition() + ", " +record.offset() + ")");
            });

            consumer.commitAsync();
        }
    }
}
