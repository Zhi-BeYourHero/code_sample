package com.zhi.controller;

import com.zhi.service.RetryService;
import com.zhi.service.TestService;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @Resource
    private TestService testService;
    @Resource
    private TestService testService1;

    @GetMapping("/callChannel")
    public String callChannel() throws Exception {
        retryService.callChannel();
        return "ok";
    }

    @GetMapping("/testScope")
    @ResponseBody
    public String testScope() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5);
        return session.toString();
    }

    @GetMapping("/testScope1")
    @ResponseBody
    public String testScope1() {
        return String.valueOf(testService1.hashCode());
    }
}
