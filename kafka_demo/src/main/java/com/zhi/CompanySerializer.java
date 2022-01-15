package com.zhi;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @Author: luowenzhi
 * @CreateTime: 8/12/2021
 * @desc:
 */
public class CompanySerializer implements Serializer<Company> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Company company) {
        if (company == null) {
            return null;
        }
        byte[] name, address;
        if (StringUtils.isNotBlank(company.getName())) {
            name = company.getName().getBytes(StandardCharsets.UTF_8);
        } else {
            name = new byte[0];
        }

        if (StringUtils.isNotBlank(company.getAddress())) {
            address = company.getAddress().getBytes(StandardCharsets.UTF_8);
        } else {
            address = new byte[0];
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(4 + 4 + name.length + address.length);
        byteBuffer.putInt(name.length);
        byteBuffer.put(name);
        byteBuffer.putInt(address.length);
        byteBuffer.put(address);
        return byteBuffer.array();
    }

    @Override
    public void close() {

    }
}
