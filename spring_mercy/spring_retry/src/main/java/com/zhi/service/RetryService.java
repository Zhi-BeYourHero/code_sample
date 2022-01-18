package com.zhi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

/**
 * @Author: luowenzhi
 * @CreateTime: 18/1/2022
 * @desc:
 */
@Slf4j
@Service
public class RetryService {

    @Retryable
    public void callChannel() throws Exception {
        queryOrder();
    }

    @Recover
    public void channelNotResp() {
        log.info("获取订单信息失败！ 发送预警！");
    }

    private void queryOrder() throws Exception{
        throw new TimeoutException("订单查询超时...");
    }
}
