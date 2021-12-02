package com.zhi.observer.example;

public class Application {
    public static void main(String[] args) {
        RegisterSubject subject = new RegisterSubject();
        subject.registerObserver(new SendMoneyObserver());
        subject.registerObserver(new SendMessageObserver());
        subject.register("20175366");
    }
}
