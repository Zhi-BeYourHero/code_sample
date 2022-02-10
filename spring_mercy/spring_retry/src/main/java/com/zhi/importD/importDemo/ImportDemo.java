package com.zhi.importD.importDemo;

import com.zhi.dto.StudentDTO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: luowenzhi
 * @CreateTime: 9/2/2022
 * @desc: <a href="https://blog.csdn.net/gongsenlin341/article/details/113281596">Spring中@Import注解的使用和实现原理（超详细！！！）</a>
 *
 */
public class ImportDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.start();
        StudentDTO studentDTO = applicationContext.getBean(StudentDTO.class);
        System.out.println(studentDTO);
        AppConfig bean = applicationContext.getBean(AppConfig.class);
        System.out.println(bean);
    }

}
