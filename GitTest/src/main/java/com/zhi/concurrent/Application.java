package com.zhi.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Application {
    private static final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("XiaoZhiDeThread-%d").build();
    public static final ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        testSubmitResult();
//        testFutureTask();
        FutureTask<String> futureTask2 = new FutureTask<>(new T2Task());
        FutureTask<String> futureTask1 = new FutureTask<>(new T1Task(futureTask2));
        new Thread(futureTask2).start();
        new Thread(futureTask1).start();
        System.out.println(futureTask1.get());
    }

    public static void testFutureTask() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1-2);
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }

    public static void testSubmitResult() throws ExecutionException, InterruptedException {
        Result oldResult = new Result();
        oldResult.setData("old data");
        Task task = new Task(oldResult);
        Future<Result> future = executorService.submit(task, oldResult);
        Result result = future.get();
        System.out.println(result == oldResult);
        System.out.println(result.getData());
    }
}
