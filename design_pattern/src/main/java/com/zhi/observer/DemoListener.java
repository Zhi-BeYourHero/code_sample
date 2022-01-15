package com.zhi.observer;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.ApplicationListener;

/**
 * @Author: luowenzhi
 * @CreateTime: 16/12/2021
 * @desc:
 */
@NoArgsConstructor
@ToString
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        System.out.println("监听到事件:" + event);
    }
}
