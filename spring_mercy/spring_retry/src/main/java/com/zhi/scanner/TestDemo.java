package com.zhi.scanner;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author: luowenzhi
 * @CreateTime: 21/1/2022
 * @desc:
 */
public class TestDemo {

    private static final String BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String toBase62(long num) {
        StringBuilder sb = new StringBuilder();
        int targetBase = BASE.length();
        do {
            int i = (int) (num % targetBase);
            sb.append(BASE.charAt(i));
            num /= targetBase;
        } while (num > 0);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toBase62(62));
        System.out.println(toBase62(1000));
        System.out.println(toBase62(11111));
    }

    public void testScan() {
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
