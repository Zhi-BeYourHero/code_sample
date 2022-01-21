package com.zhi.scanner;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author: luowenzhi
 * @CreateTime: 21/1/2022
 * @desc:
 */
public class TestDemo {

    public static void main(String[] args) {
        String BASE_PACKAGE = "com.zhi.scanner";
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        MyClassPathDefinitionScanner definitionScanner = new MyClassPathDefinitionScanner(genericApplicationContext, MyScanBean.class);
        definitionScanner.registerTypeFilter();
        int beanCount = definitionScanner.scan(BASE_PACKAGE);
        genericApplicationContext.refresh();
        System.out.println(beanCount);
        String[] beanDefinitionNames = genericApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
