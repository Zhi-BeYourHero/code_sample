package com.zhi.controller;

import com.zhi.service.RetryService;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @Author: luowenzhi
 * @CreateTime: 18/1/2022
 * @desc:
 */
@Controller
@EnableRetry
public class TestController {

    @Resource
    private RetryService retryService;

    @GetMapping("/callChannel")
    public String callChannel() throws Exception {
        retryService.callChannel();
        return "ok";
    }
}
