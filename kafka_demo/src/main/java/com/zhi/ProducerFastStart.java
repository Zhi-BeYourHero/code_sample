package com.zhi;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: luowenzhi
 * @CreateTime: 8/12/2021
 * @desc:
 */
public class ProducerFastStart {
    private static final String brokerList = "localhost:9091,localhost:9092";
    private static final String topic = "topic-demo";

    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CompanySerializer.class.getName());
        properties.setProperty(ProducerConfig.CLIENT_ID_CONFIG, "zhi_produce");
        properties.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, DemoPartitioner.class.getName());
        properties.setProperty(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, ProducerPrefixInterceptor.class.getName());
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "-1");
        properties.setProperty(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "16384");
        properties.setProperty(ProducerConfig.RETRIES_CONFIG, "3");
        properties.setProperty(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "100");
        return properties;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long begin = System.currentTimeMillis();
        KafkaProducer<String, Company> producer = new KafkaProducer<>(initConfig());
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, Company> producerRecord = new ProducerRecord<>(topic, "key",new Company("companyName", "companyAddress" + i));
            Future<RecordMetadata> metadataFuture = producer.send(producerRecord);
            RecordMetadata recordMetadata = metadataFuture.get();
            System.out.println(recordMetadata.partition() + " :" + recordMetadata.topic() + ":" + recordMetadata.offset());
        }
        producer.close();
        System.out.println("spent time:" + (System.currentTimeMillis() - begin));
    }
}