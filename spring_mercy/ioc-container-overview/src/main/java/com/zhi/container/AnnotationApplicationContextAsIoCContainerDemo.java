package com.zhi.container;

import com.zhi.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author: luowenzhi
 * @CreateTime: 7/12/2021
 * @desc:
 */
@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        applicationContext.refresh();

        Map<String, User> userMap = applicationContext.getBeansOfType(User.class);
        for (Map.Entry<String, User> stringUserEntry : userMap.entrySet()) {
            String key = stringUserEntry.getKey();
            User value = stringUserEntry.getValue();
            System.out.println(key + ":" + value);
        }

        applicationContext.close();
    }

    @Bean
    public User newBean() {
        return new User(1L, "小智");
    }
}