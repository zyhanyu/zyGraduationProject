package com.ithanyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ithanyu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

// @Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM `sys_user`")
    List<User> findAll();

    @Insert("insert into sys_user(username,password,nickname,email,phone,address) values (#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);


    int update(User user);

    @Delete("delete from sys_user where id =  #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from sys_user where username like #{username} limit #{pageNum},#{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize,String username);

    @Select("select count(*) from sys_user where username like #{username}  ")
    Integer selectTotal(String username);
}










