package com.zhi.concurrent;

public class Task implements Runnable{
    Result result;

    public Task(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String data = result.getData();
        System.out.println(data);
        result.setData("new data");
    }
}
