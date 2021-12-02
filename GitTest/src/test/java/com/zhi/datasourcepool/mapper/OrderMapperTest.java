package com.zhi.datasourcepool.mapper;


import com.zhi.datasourcepool.Application;
import com.zhi.datasourcepool.dataobject.OrderDO;
import com.zhi.datasourcepool.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: luowenzhi
 * @CreateTime: 14/11/2021
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class OrderMapperTest {
    @Resource
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testMethod1() {
        orderService.method01();
    }

    @Test
    public void testMethod2() {
        orderService.method02();
    }

    @Test
    public void testMethod3() {
        orderService.method03();
    }

    @Test
    public void testMethod4() {
        orderService.method04();
    }

    @Test
    public void testMethod5() {
        orderService.method05();
    }

    @Test
    public void testSelectById() {
        for (int i = 0; i < 10; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(10);
        orderMapper.insert(order);
    }
}