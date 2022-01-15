package com.zhi.ratelimiter.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: luowenzhi
 * @CreateTime: 17/12/2021
 * @desc:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleConfig {
    private List<AppRuleConfig> rules;

    @Data
    @AllArgsConstructor
    public static class AppRuleConfig {
        private String appId;
        private List<ApiLimit> limits;
    }
}