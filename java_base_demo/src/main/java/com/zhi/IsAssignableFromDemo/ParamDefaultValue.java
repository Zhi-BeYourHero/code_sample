package com.zhi.IsAssignableFromDemo;

import java.lang.annotation.*;

/**
 * @Author: luowenzhi
 * @CreateTime: 20/1/2022
 * @desc:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface ParamDefaultValue {
    String value();
}