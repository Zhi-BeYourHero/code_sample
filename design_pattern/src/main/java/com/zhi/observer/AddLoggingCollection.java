package com.zhi.observer;

import com.google.common.collect.ForwardingCollection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: luowenzhi
 * @CreateTime: 16/12/2021
 * @desc:v 装饰器模式 or wrapper
 */
public class AddLoggingCollection extends ForwardingCollection<String> {
    private Collection<String> collection;

    public AddLoggingCollection(Collection<String> collection) {
        this.collection = collection;
    }

    @Override
    protected Collection<String> delegate() {
        return this.collection;
    }

    @Override
    public boolean add(String element) {
        System.out.println("add。。。");
        return super.add(element);
    }

    public static void main(String[] args) {
        AddLoggingCollection logCollection = new AddLoggingCollection(new ArrayList<>());
        logCollection.add("123");
    }
}
