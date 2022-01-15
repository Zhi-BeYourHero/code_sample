package com.zhi.observer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: luowenzhi
 * @CreateTime: 16/12/2021
 * @desc:
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("com.zhi.observer.Main");
        Method printEx = clazz.getMethod("printEx", int.class);
        for (int i = 0; i < 20; i++) {
            printEx.invoke(null, i);
        }
    }

    public static void printEx(int i) {
        new Exception("#"+i).printStackTrace();
    }

    public void publishEvent() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Main.class);
        applicationContext.refresh();
        applicationContext.addApplicationListener(new DemoListener());
        applicationContext.publishEvent(applicationContext.getBean(DemoEvent.class));
    }

    @Bean
    public DemoEvent demoEvent() {
        return new DemoEvent("213", "123");
    }
}
