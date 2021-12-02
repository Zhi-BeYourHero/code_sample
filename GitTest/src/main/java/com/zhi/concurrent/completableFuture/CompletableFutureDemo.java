package com.zhi.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 任务是有时序关系的，比如串行关系，并行关系和汇聚关系等
 * CompletionStage接口可以清晰地描述任务之间的时序关系thenCombine是一种汇聚关系，只有当所有依赖的任务都执行完成后才执行当前的任务...
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "洗水壶");
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + "泡开水");
            sleep(5000);
            return "小小智烧好水了";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "洗茶壶");
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + "洗茶杯");
            sleep(2000);
            System.out.println(Thread.currentThread().getName() + "拿茶叶");
            return "红茶";
        });

        CompletableFuture<String> f3 = future1.thenCombine(future2, (tf1, tf2) -> {
            System.out.println(Thread.currentThread().getName() + "拿到茶叶：" + tf2);
            System.out.println(Thread.currentThread().getName() + "泡茶");
            System.out.println(Thread.currentThread().getName() + tf1);
            return "上茶" + tf2;
        });
        System.out.println(Thread.currentThread().getName() + f3.join());

    }

    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
