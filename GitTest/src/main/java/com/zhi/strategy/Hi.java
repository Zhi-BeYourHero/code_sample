package com.zhi.strategy;

import java.math.BigDecimal;

/**
 * HelloWorld
 */
public class Hi {
    public static void main(String[] args) {
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")).longValue());
        long value = Math.addExact(Long.MAX_VALUE, 1);
        System.out.println(value);
    }
}
