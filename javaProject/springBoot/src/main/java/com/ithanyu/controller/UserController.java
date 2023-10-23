package com.ithanyu.controller;

import com.ithanyu.entity.User;
import com.ithanyu.mapper.UserMapper;
import com.ithanyu.service.UserService;
import org.apache.ibatis.annotations.Delete;
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

    // 新增和更新
    @PostMapping
    public Integer save(@RequestBody User user){
        // 新增或更新
        return userService.save(user);
    }

    // 查看所有数据
    @GetMapping
    public List<User> index(){
        List<User> all = userMapper.findAll();
        return all;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }
}
