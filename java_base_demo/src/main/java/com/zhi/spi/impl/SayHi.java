package com.zhi.spi.impl;

import com.zhi.spi.Say;

/**
 * @Author: luowenzhi
 * @CreateTime: 6/2/2022
 * @desc:
 */
public class SayHi implements Say {
    @Override
    public void say() {
        System.out.println("Hi， lwz");
    }
}
