package com.zhi.jvm;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Author: luowenzhi
 * @CreateTime: 6/2/2022
 * @desc: <a href="https://www.cnblogs.com/webor2006/p/9029910.html">不同的类加载器作用与加载动作分析</a>
 */
public class ClassLoaderDemoApp {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        Enumeration<URL> resources = contextClassLoader.getResources("java_base_demo/com/zhi/jvm/ClassLoaderDemoApp.java");
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }
    }


}
