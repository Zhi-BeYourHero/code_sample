package com.zhi.ratelimiter;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.zhi.ratelimiter.alg.RateLimitAlg;
import com.zhi.ratelimiter.rule.ApiLimit;
import com.zhi.ratelimiter.rule.RateLimitRule;
import com.zhi.ratelimiter.rule.RuleConfig;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author: luowenzhi
 * @CreateTime: 17/12/2021
 * @desc: 限流器
 */
public class RateLimiter {
    private Logger logger = LoggerFactory.getLogger(RateLimiter.class);
    // 为每个API存储对应的限流计数器...
    private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimiter() throws IOException {
        RuleConfig ruleConfig = null;
        try (InputStream in = this.getClass().getResourceAsStream("ratelimiter-rule.yml")){
            if (in != null) {
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        }
        rule = new RateLimitRule(ruleConfig);
    }

    public boolean limit(String appId, String url) {
        ApiLimit apiLimit = rule.getLimit(appId, url);
        if (apiLimit == null) {
            return true;
        }

        String counterKey = StringUtils.joinWith(":", appId, url);
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if (rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new RateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if (rateLimitCounter == null) {
                rateLimitCounter = newRateLimitCounter;
            }
        }

        // 判断是否限流
        return rateLimitCounter.tryAcquire();
    }
}