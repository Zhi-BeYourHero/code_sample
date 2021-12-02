package com.zhi.datasourcepool.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhi.datasourcepool.constant.DBConstants;
import com.zhi.datasourcepool.dataobject.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: luowenzhi
 * @CreateTime: 14/11/2021
 * @desc:
 */
@Repository
public interface OrderMapper {
    @DS(DBConstants.DATASOURCE_SLAVE)
    OrderDO selectById(@Param("id") Integer id);

    @DS(DBConstants.DATASOURCE_MASTER)
    int insert(OrderDO entity);
}