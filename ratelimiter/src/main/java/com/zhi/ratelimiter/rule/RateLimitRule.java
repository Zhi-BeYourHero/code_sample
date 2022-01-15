package com.zhi.ratelimiter.rule;

/**
 * @Author: luowenzhi
 * @CreateTime: 17/12/2021
 * @desc: 获取限流规则,因为并不一定每次都传完整的API， 需要前缀匹配，推荐使用Trie前缀树
 */
public class RateLimitRule {
    private RuleConfig ruleConfig;

    public RateLimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public ApiLimit getLimit(String appId, String api) {
        //
        return new ApiLimit("1", 1);
    }
}
