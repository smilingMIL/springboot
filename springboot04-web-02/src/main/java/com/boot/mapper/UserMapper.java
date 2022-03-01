package com.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.bean.User;

/**
 * mybatis-plus  只需要我们的Mapper继承 BaseMapper 就可以拥有crud能力
 */
public interface UserMapper extends BaseMapper<User> {


}
