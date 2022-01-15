package com.zhi.ratelimiter.rule;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: luowenzhi
 * @CreateTime: 17/12/2021
 * @desc:
 */
@Data
@AllArgsConstructor
public class ApiLimit {
    private static final int DEFAULT_TIME_UNIT = 1; // 1 second
    private String api;
    private int limit;
    private int unit = DEFAULT_TIME_UNIT;

    public ApiLimit(String api, int limit) {
        this(api, limit, DEFAULT_TIME_UNIT);
    }
}
