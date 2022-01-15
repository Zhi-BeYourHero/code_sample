package com.zhi.observer;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.sun.tools.javac.util.Assert;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.*;
import java.util.*;

/**
 * @Author: luowenzhi
 * @CreateTime: 14/12/2021
 * @desc:
 */
public class EventBusMain {
    @ToString
    @AllArgsConstructor
    static class MyEvent {
        public int value;
    }

    @ToString
    static class MyListener {
        public int value;

        @Subscribe
        public void listen(MyEvent e) {
            // 监听事件
            System.out.println("This is " + this + ", 收到事件：" + e.toString());
            value += e.value;
        }

        @Subscribe
        public void listen2(MyEvent e) {
            System.out.println("This is 监听方法2 " + this + ", 收到事件：" + e.toString());
            value += e.value;
        }
    }

    public static void main(String[] args) {
//        testEventBus();
//       testJdkUtilObserver();
//        Integer integer = IntegerCache.cache[128 + 1];
//        System.out.println(integer);
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);
    }

    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = Integer.parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    }

    public static void testEventBus() {
        EventBus bus = new EventBus("myEventBus"); // 定义总线
        MyListener myListener = new MyListener();
        bus.register(myListener);   // 注册监听者
        System.out.println("Before: " + myListener.toString());
        bus.post(new MyEvent(1));   // 向总线发布时间
        bus.post(new MyEvent(2));
        System.out.println("After: " + myListener.toString());
    }

    public Object serializeAndDeSerialize() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(new Object());

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return objectInputStream.readObject();
    }

    public static void testJdkUtilObserver() {
        MyObservable observable = new MyObservable();
        observable.addObserver(new MyObserver1());
        observable.addObserver(new MyObserver2());
        observable.setChanged();
        observable.notifyObservers("小白兔，白又白");
    }

    public static class MyObservable extends Observable {
        public void setChanged() {
            super.setChanged();
        }
    }

    @ToString
    public static class MyObserver1 implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.printf("observable1:%s, arg:%s%n", o, arg);
        }
    }

    @ToString
    public static class MyObserver2 implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.printf("observable2:%s, arg:%s%n", o, arg);
        }
    }
}
