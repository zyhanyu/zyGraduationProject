package com.ithanyu.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ithanyu.controller.dto.UserDto;
import com.ithanyu.entity.User;
import com.ithanyu.mapper.UserMapper;
import com.ithanyu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyhanyu
 * @since 2023-10-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final Log LOG = Log.get();

    @Override
    public boolean login(UserDto userDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDto.getUsername());
        queryWrapper.eq("password",userDto.getPassword());

        // List<User> list = list(queryWrapper);// 方式一
        // return list.size() != 0;

        try {
            User user = getOne(queryWrapper);
            return user != null;
        }catch(Exception e){
            LOG.error(e);
            return false;
        }

    }
}
