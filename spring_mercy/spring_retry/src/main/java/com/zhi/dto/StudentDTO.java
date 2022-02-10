package com.zhi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: luowenzhi
 * @CreateTime: 9/2/2022
 * @desc:
 */
@Data
public class StudentDTO implements Serializable {
    private String name = "笑笑就好";
    private Integer age = 12;
}
