package com.zhi.concurrent;

import java.util.concurrent.Callable;

public class T2Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "T2 洗茶壶...");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "T2 洗茶杯");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "T2 拿茶叶");
        Thread.sleep(1000);
        return "红茶";
    }
}
