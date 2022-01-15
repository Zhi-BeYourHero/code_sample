package com.zhi.observer;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: luowenzhi
 * @CreateTime: 16/12/2021
 * @desc:
 */
@ToString
public class DemoEvent extends ApplicationEvent {
    private final String msg;

    public DemoEvent(String source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
