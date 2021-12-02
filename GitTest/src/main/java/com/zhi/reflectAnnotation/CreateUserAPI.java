package com.zhi.reflectAnnotation;

public class CreateUserAPI extends AbstractAPI{
    @BankAPIField(order = 1, type = "S", length = 10)
    private String name;

    @BankAPIField(order = 2, type = "S", length = 18)
    private String id;

    @BankAPIField(order = 3, type = "N", length = 5)
    private int age;

    @BankAPIField(order = 4, type = "S", length = 11)
    private int mobile;
}
