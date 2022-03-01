package com.docker.mapper;

import com.docker.entities.User;
import com.docker.entities.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

}