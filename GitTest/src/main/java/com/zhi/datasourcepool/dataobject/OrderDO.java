package com.zhi.datasourcepool.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: luowenzhi
 * @CreateTime: 14/11/2021
 * @desc:
 */
@Setter
@Getter
@ToString
public class OrderDO {
    /**
     * 订单编号
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;
}
