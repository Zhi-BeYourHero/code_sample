package com.zhi.IsAssignableFromDemo.dto;

import com.zhi.IsAssignableFromDemo.ParamDefaultValue;

/**
 * @Author: luowenzhi
 * @CreateTime: 20/1/2022
 * @desc:
 */
public class Father {

    @ParamDefaultValue("罗大帅")
    private String name = "你好呀";

    @ParamDefaultValue(value = "12")
    private Integer age;

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
