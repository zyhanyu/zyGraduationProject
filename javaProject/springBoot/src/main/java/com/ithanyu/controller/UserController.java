package com.ithanyu.controller;

import com.ithanyu.entity.User;
import com.ithanyu.mapper.UserMapper;
import com.ithanyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public Integer save(@RequestBody User user){
        // 新增或更新
        return userService.save(user);
    }

    @GetMapping
    public List<User> index(){
        List<User> all = userMapper.findAll();
        return all;
    }
}
