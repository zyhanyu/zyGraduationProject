package com.ithanyu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ithanyu.entity.User;
import com.ithanyu.mapper.UserMapper;
import org.apache.catalina.util.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author:1276046082@qq.com
 */


@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    public boolean saveUser(User user) {
        // if (user.getId() == null){
        //     return save(user);// mybatis-plus 提供的方法，表示插入数据
        // }else {
        //     return updateById(user);
        // }
        return saveOrUpdate(user);
    }
    // @Autowired
    // private UserMapper userMapper;

    // public int save(User user){
    //     if (user.getId() == null){ // 没有 id 表示为新增
    //         return userMapper.insert(user);
    //     }else{ // 否则为更新
    //         return userMapper.update(user);
    //     }
    // }
}
