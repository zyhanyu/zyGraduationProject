package com.ithanyu.controller;

import com.ithanyu.entity.User;
import com.ithanyu.mapper.UserMapper;
import com.ithanyu.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean save(@RequestBody User user){
        // 新增或更新
        return userService.saveUser(user);
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

    // 分页查询
    // 接口路径：/user/page
    // @RequestParam接收
    // limit第一个参数 = (pageNum - 1)*pageSize
    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username){
        pageNum = (pageNum - 1) * pageSize;
        username = "%"+username+"%";
        Integer total = userMapper.selectTotal(username);
        List<User> data = userMapper.selectPage(pageNum, pageSize,username);
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
