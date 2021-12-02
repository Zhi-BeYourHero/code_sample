package com.zhi.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/get")
    public String get() {
        return "Get Message";
    }

    @GetMapping("/list")
    public String list() {
        return "List Message";
    }

}
