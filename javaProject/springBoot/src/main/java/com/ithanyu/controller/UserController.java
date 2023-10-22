package com.ithanyu.controller;

import com.ithanyu.entity.User;
import com.ithanyu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> index(){
        List<User> all = userMapper.findAll();
        return all;
    }
}
