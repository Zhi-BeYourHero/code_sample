package com.zhi.strategy.factory;

import com.zhi.strategy.discount.DiscountStrategy;
import com.zhi.strategy.discount.impl.DiscountAStrategy;
import com.zhi.strategy.discount.impl.DiscountBStrategy;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategyFactory {

    public static final Map<String, DiscountStrategy> DISCOUNT_STRATEGY_MAP = new HashMap<>();

    static {
        DISCOUNT_STRATEGY_MAP.put("discountA", new DiscountAStrategy());
        DISCOUNT_STRATEGY_MAP.put("discountB", new DiscountBStrategy());
    }

    public static DiscountStrategy getStrategy(String strategyKey) {
        return DISCOUNT_STRATEGY_MAP.get(strategyKey);
    }
}
