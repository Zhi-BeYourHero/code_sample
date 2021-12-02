package com.zhi.datasourcepool.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: luowenzhi
 * @CreateTime: 14/11/2021
 * @desc:
 */
@Getter
@Setter
@ToString
public class UserDO {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
}