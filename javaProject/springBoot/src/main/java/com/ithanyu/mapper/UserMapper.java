package com.ithanyu.mapper;

import com.ithanyu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Insert("insert into sys_user(username,password,nickname,email,phone,address) values (#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

    @Update("update sys_user set username = #{username},password=#{password},nickname=#{nickname},email=#{email},phone=#{phone},address=#{address} where id = #{id}")
    int update(User user);
}










