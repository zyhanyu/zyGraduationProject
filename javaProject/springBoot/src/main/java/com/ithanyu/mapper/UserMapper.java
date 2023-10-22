package com.ithanyu.mapper;

import com.ithanyu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `sys_user`")
    List<User> findAll();
}
