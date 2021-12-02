package com.zhi.observer.example;

public class SendMessageObserver implements RegisterObserver{
    @Override
    public void processAfterRegisterSuccessfully(String uid) {
        System.out.println("发放邮件，给用户" + uid);
    }
}
