package com.zhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @Author: luowenzhi
 * @CreateTime: 18/1/2022
 * @desc:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.zhi"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.zhi.importD.*")})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
