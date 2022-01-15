package com.zhi;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: luowenzhi
 * @CreateTime: 8/12/2021
 * @desc:
 */
public class ProducerPrefixInterceptor implements ProducerInterceptor<String, Company> {
    private final AtomicInteger successCount = new AtomicInteger(0);
    private final AtomicInteger failCount = new AtomicInteger(0);
    @Override
    public ProducerRecord<String, Company> onSend(ProducerRecord<String, Company> record) {
        String prefix = "prefix_add_";
        Company company = record.value();
        company.setName(prefix+company.getName());
        return new ProducerRecord<>(record.topic(), record.key(), company);
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (exception == null) {
            successCount.incrementAndGet();
        } else {
            failCount.incrementAndGet();
        }
    }

    @Override
    public void close() {
        System.out.println("成功次数为："+successCount);
        System.out.println("失败次数为："+failCount);
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
