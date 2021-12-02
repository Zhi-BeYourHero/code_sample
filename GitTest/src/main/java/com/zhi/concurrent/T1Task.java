package com.zhi.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class T1Task implements Callable<String> {

    private FutureTask<String> futureTask;

    public T1Task(FutureTask futureTask) {
        this.futureTask = futureTask;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "T1 洗水壶");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "T1 烧开水");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + "T1 水烧好了，准备泡茶");
        String format = String.format("拿到茶叶：%s去泡茶", futureTask.get());
        System.out.println(format);
        return "茶泡好了，真香～";
    }
}
