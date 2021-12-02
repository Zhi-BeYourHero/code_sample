package com.zhi.observer.tmplate;

public class Application {
    public static void main(String[] args) {
        Subject concreteSubject = new ConcreteSubject();
        ObserverOne observerOne = new ObserverOne();
        concreteSubject.registerObserver(observerOne);
        concreteSubject.registerObserver(new ObserverTwo());
        concreteSubject.notifyObserver();
        concreteSubject.removeObserver(observerOne);
        concreteSubject.notifyObserver();
    }
}
