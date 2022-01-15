package com.zhi.ratelimiter.alg;

import com.zhi.ratelimiter.RateLimiter;

/**
 * @Author: luowenzhi
 * @CreateTime: 17/12/2021
 * @desc: 限流算法接口
 */
public class RateLimitAlg {

    private Integer limit;
    public RateLimitAlg(Integer limit) {
        this.limit = limit;
    }

    public boolean tryAcquire() {
        return true;
    }
}
