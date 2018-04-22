package com.mmedum.howtokafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.logging.Logger;

public class MessageProducer {

    private static final Logger LOGGER = Logger.getLogger(MessageProducer.class.getName());


    private final static String TOPIC = "test-topic";
    private final static String SERVERS = "localhost:9092";

    private Producer<Long, String> createProducer(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "MessageProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    public void runMessageProducer(final int numberOfMessagesToSend){
        final Producer<Long, String> producer = createProducer();
        for(long i=0; i<numberOfMessagesToSend; i++){

            final ProducerRecord<Long, String> record = new ProducerRecord<>(TOPIC, i, "Hello " + i);
            producer.send(record, (metadata, exception) -> {

                if(metadata != null){
                    String msg = "Sent record: " + record.key() + ", value: " + record.value() +
                            ", partition: " + metadata.partition() + ", offset: " + metadata.offset();
                    LOGGER.info(msg);
                } else {
                    exception.printStackTrace();
                }
            });
        }
        producer.flush();
        producer.close();
    }
}
