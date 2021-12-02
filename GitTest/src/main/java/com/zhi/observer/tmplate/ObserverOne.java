package com.zhi.observer.tmplate;

public class ObserverOne implements Observer{
    @Override
    public void update(String msg) {
        System.out.println(getClass().getName() + msg);
    }
}
