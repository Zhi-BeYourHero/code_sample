package com.zhi.reflectAnnotation;

import java.math.BigDecimal;

@BankAPI(url = "https://www.baidu.com", desc = "目的地址")
public class PayAPI extends AbstractAPI{
    @BankAPIField(order = 1, type = "N", length = 20)
    private int uid;

    @BankAPIField(order = 2, type = "M", length = 10)
    private BigDecimal amount;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}