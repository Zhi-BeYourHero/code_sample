package com.zhi.service;

import com.zhi.dto.StudentDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @Author: luowenzhi
 * @CreateTime: 13/2/2022
 * @desc:
 */
@Configuration
@PropertySource("classpath:service.properties")
public class AppConfig {
    @Resource
    private Environment environment;

    @Bean("testBean")
    public StudentDTO testBean() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(environment.getProperty("testbean.name"));
        studentDTO.setAge(12);
        return studentDTO;
    }

}
