package com.zhi.project.api.enums;

/**
 * @Author: luowenzhi
 * @CreateTime: 10/2/2022
 * @desc: 对外暴露的枚举类
 */
public enum DemoEnumType {
    DEMO_ENUM("demo"),
    ;
    private String value;
    DemoEnumType(final String value) {
        this.value = value;
    }
}