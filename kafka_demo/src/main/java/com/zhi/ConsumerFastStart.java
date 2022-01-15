package com.zhi;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: luowenzhi
 * @CreateTime: 8/12/2021
 * @desc:
 */
public class ConsumerFastStart {
    private static final String brokerList = "localhost:9091,localhost:9092";
    private static final String topic = "topic-demo";
    private static final String group = "zhi-group";

    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
//        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "none");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CompanyDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, group);
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, "zhi_consumersaf");
        return properties;
    }

    public static void main(String[] args) {
//        fastStartSync();
//        relation();
//        fastStartASync();
        seek();
    }

    /**
     * 论证 lastConsumedOffset、committed offset 和 position 之间的关系
     */
    public static void relation() {
        KafkaConsumer<String, Company> consumer = new KafkaConsumer<String, Company>(initConfig());
        TopicPartition topicPartition = new TopicPartition(topic, 1);
        consumer.assign(Collections.singleton(topicPartition));
        long lastConsumedOffset = -1L;
        while (true) {
            ConsumerRecords<String, Company> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            if (consumerRecords.isEmpty()) {
                break;
            }
            List<ConsumerRecord<String, Company>> records = consumerRecords.records(topicPartition);
            ConsumerRecord<String, Company> lastRecord = records.get(records.size() - 1);
            lastConsumedOffset = lastRecord.offset();
            consumer.commitSync();
        }
        System.out.println("lastConsumedOffset: "+  lastConsumedOffset);
        System.out.println("committed offset: " + consumer.committed(topicPartition, Duration.ofMillis(1000)).offset());
        System.out.println("the offset of the next record is: " + consumer.position(topicPartition));
        consumer.close();
    }

    public static void seek() {
        KafkaConsumer<String, Company> consumer = new KafkaConsumer<String, Company>(initConfig());
//        TopicPartition topicPartition = new TopicPartition(topic, 1);
        consumer.subscribe(Collections.singleton(topic));
        consumer.poll(Duration.ofMillis(1000));
        Set<TopicPartition> assignment = consumer.assignment();
        System.out.println(assignment);

        while (true) {
            for (TopicPartition topicPartition : assignment) {
                ConsumerRecords<String, Company> consumerRecords = consumer.poll(Duration.ofMillis(1000));
                List<ConsumerRecord<String, Company>> records = consumerRecords.records(topicPartition);
                consumer.commitSync();
            }
        }
    }

    public static void fastStartASync() {
        KafkaConsumer<String, Company> consumer = new KafkaConsumer<>(initConfig());
        consumer.subscribe(Collections.singleton(topic));
        while (true) {
            ConsumerRecords<String, Company> consumerRecords = consumer.poll(Duration.ofMillis(10));
            for (ConsumerRecord<String, Company> record : consumerRecords) {
                System.out.println("first topic = " + record.topic()
                        + ", partition = "+ record.partition()
                        + ", offset = " + record.offset());
                System.out.println("first key = " + record.key()
                        + ", value = " + record.value());
            }

            consumer.commitAsync((offsets, exception) -> {
                if (exception == null) {
                    System.out.println("commit success");
                } else {
                    System.out.println("commit fail");
                }
            });
        }
    }

    public static void fastStartSync() {
        KafkaConsumer<String, Company> consumer = new KafkaConsumer<>(initConfig());
        consumer.subscribe(Collections.singleton(topic));
        while (true) {
            ConsumerRecords<String, Company> consumerRecords = consumer.poll(Duration.ofMillis(10));
            for (ConsumerRecord<String, Company> record : consumerRecords) {
                System.out.println("first topic = " + record.topic()
                        + ", partition = "+ record.partition()
                        + ", offset = " + record.offset());
                System.out.println("first key = " + record.key()
                        + ", value = " + record.value());
                TopicPartition topicPartition = new TopicPartition(record.topic(), record.partition());
                consumer.commitSync(Collections.singletonMap(topicPartition, new OffsetAndMetadata(record.offset() + 1)));
                System.out.println("lastConsumedOffset: "+  record.offset());
                System.out.println("committed offset: " + consumer.committed(topicPartition, Duration.ofMillis(1000)).offset());
                System.out.println("the offset of the next record is: " + consumer.position(topicPartition));
            }
        }
    }
}
