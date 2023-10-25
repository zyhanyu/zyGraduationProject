package com.ithanyu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    private UserService userService;

    // 新增和更新
    @PostMapping
    public boolean save(@RequestBody User user){
        // 新增或更新
        return userService.saveUser(user);
    }

    // 查看所有数据
    @GetMapping
    public List<User> findAll(){
        return userService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    @DeleteMapping("/del/batch/")
    public boolean deleteBatch(@PathVariable List<Integer> ids){
        return userService.removeByIds(ids);
    }

    // 分页查询
    // 接口路径：/user/page
    // @RequestParam接收
    // limit第一个参数 = (pageNum - 1)*pageSize
    // @GetMapping("/page")
    // public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String username){
    //     pageNum = (pageNum - 1) * pageSize;
    //     username = "%"+username+"%";
    //     Integer total = userMapper.selectTotal(username);
    //     List<User> data = userMapper.selectPage(pageNum, pageSize,username);
    //     Map<String,Object> res = new HashMap<>();
    //     res.put("data",data);
    //     res.put("total",total);
    //     return res;
    // }

    // 分页查询  - mybatis-plus的方式
    @GetMapping("/page")
    public IPage<User> findPage(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(defaultValue = "") String username,
            @RequestParam(defaultValue = "")  String nickname,
            @RequestParam(defaultValue = "")  String address){
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!"".equals(username)){
            queryWrapper.like("username", username);
        }
        if (!"".equals(nickname)){
            // queryWrapper.or().like("address", address);
        }
        if (!"".equals(address)){
            queryWrapper.like("address", address);
        }
        // queryWrapper.or().like("address", address);
        return userService.page(page,queryWrapper);
    }
}
