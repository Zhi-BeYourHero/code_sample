package com.zhi.service;

import com.zhi.dto.StudentDTO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: luowenzhi
 * @CreateTime: 13/2/2022
 * @desc:
 */
public class TestApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.start();
        StudentDTO testBean = applicationContext.getBean("testBean",StudentDTO.class);
        System.out.println(testBean);
    }
}
