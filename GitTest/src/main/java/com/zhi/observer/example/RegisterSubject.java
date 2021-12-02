package com.zhi.observer.example;

import java.util.ArrayList;
import java.util.List;

public class RegisterSubject {
    private static final List<RegisterObserver> observers = new ArrayList<>();

    void registerObserver(RegisterObserver registerObserver) {
        observers.add(registerObserver);
    }
    void register(String uid) {
        System.out.println("注册成功..., 用户id为"+uid);
        for (RegisterObserver observer : observers) {
            observer.processAfterRegisterSuccessfully(uid);
        }
    }
}
