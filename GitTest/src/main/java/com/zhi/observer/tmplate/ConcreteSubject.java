package com.zhi.observer.tmplate;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    public static final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update("被观察者发生了改变"));
    }
}
