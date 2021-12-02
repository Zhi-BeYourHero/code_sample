package com.zhi.strategy.discount.impl;

import com.zhi.strategy.discount.DiscountStrategy;

public class DiscountBStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return 0.75d;
    }
}
