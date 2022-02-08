package com.zhi.spi;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author: luowenzhi
 * @CreateTime: 6/2/2022
 * @desc:
 */
public class Application {
    public static void main(String[] args) throws IOException {
        Enumeration<URL> systemResources = ClassLoader.getSystemResources("META-INF/services/com.zhi.spi.Say");
        URL url = systemResources.nextElement();
        System.out.println(url);
        ServiceLoader<Say> serviceLoader = ServiceLoader.load(Say.class);
        Iterator<Say> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            Say say = iterator.next();
            say.say();
        }
    }
}
