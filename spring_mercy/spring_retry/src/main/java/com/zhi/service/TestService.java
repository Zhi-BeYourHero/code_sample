package com.zhi.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Author: luowenzhi
 * @CreateTime: 12/2/2022
 * @desc:
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  //通过@Scope注解指定是单例bean还是多类型。
public class TestService {

    public void say() {
        System.out.println("Say Hi");
    }
}