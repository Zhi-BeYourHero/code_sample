package com.zhi.datasourcepool.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhi.datasourcepool.constant.DBConstants;
import com.zhi.datasourcepool.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: luowenzhi
 * @CreateTime: 14/11/2021
 * @desc:
 */
@Repository
@DS(DBConstants.DATASOURCE_USERS)
public interface UserMapper {

    UserDO selectById(@Param("id") Integer id);

}