package com.zhi.importD.importBeanDefinitionRegistrar;

import com.zhi.dto.StudentDTO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: luowenzhi
 * @CreateTime: 9/2/2022
 * @desc:
 */
public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.start();
        StudentDTO bean = applicationContext.getBean(StudentDTO.class);
        System.out.println(bean);
    }
}
