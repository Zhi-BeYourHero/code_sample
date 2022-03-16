package com.zhi.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

/**
 * @Author: luowenzhi
 * @CreateTime: 8/3/2022
 * @desc:
 */
@Slf4j
public class AsyncService {
    @Async
    public void test2() {
        try {
            log.info(Thread.currentThread().getName() + " in test2, before sleep.");
            Thread.sleep(2000);
            log.info(Thread.currentThread().getName() + " in test2, after sleep.");
        }catch (InterruptedException e) {
            log.error("sleep error");
        }
    }


}