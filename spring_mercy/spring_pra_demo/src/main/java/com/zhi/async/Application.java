package com.zhi.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author: luowenzhi
 * @CreateTime: 8/3/2022
 * @desc:
 */
@Slf4j
@SpringBootApplication
@EnableAsync
public class Application {
    public static void main(String[] args) {
        log.info("spring boot开始启动...");
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        for (String activeProfile : activeProfiles) {
            log.info("当前环境为" + activeProfile);
        }
        log.info("spring boot启动成功...");
    }
}
