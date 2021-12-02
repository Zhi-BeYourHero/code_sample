package com.zhi.observer.tmplate;

public class ObserverTwo implements Observer{
    @Override
    public void update(String msg) {
        System.out.println(getClass().getName() + msg);
    }
}
