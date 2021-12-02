package com.zhi.observer.example;

public class SendMoneyObserver implements RegisterObserver{
    @Override
    public void processAfterRegisterSuccessfully(String uid) {
        System.out.println("发放体验金，给用户" + uid);
    }
}
