package com.zhi.strategy.discount;

import com.zhi.strategy.factory.DiscountStrategyFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BuyApplication {

    public static void main(String[] args) throws IOException {
//        double totalPrice = 100.5d;
//        DiscountStrategy strategy = DiscountStrategyFactory.getStrategy("discountB");
//        double finalPrice = totalPrice * strategy.discount();
//        System.out.println(finalPrice);
        Properties properties = new Properties();
        properties.load(new FileInputStream("aaa.properties"));
        String strategy = properties.getProperty("strategy");
        System.out.println(strategy);
    }
}