package com.ithanyu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ithanyu.common.Constants;
import com.ithanyu.controller.dto.UserDto;
import com.ithanyu.entity.User;
import com.ithanyu.exception.ServiceException;
import com.ithanyu.mapper.UserMapper;
import com.ithanyu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ithanyu.utils.TokenUtils;
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
    public UserDto login(UserDto userDto) {
        User one = getUserInfo(userDto);
        if (one != null){
            BeanUtil.copyProperties(one,userDto,true);
            // 设置token
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword().toString());
            userDto.setToken(token);
            return userDto;
        }else{
            throw new  ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    @Override
    public User register(UserDto userDto) {
        User one = getUserInfo(userDto);
        if(one == null){
            one = new User();
            BeanUtil.copyProperties(userDto,one,true);
            save(one);
        }else{
            throw new  ServiceException(Constants.CODE_600,"用户已存在 ");
        }
        return one;
    }

    private User getUserInfo(UserDto userDto){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDto.getUsername());
        queryWrapper.eq("password",userDto.getPassword());
        User one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        }catch(Exception e){
            LOG.error(e);
            throw new  ServiceException(Constants.CODE_500,"系统错误");
        }
        return one;
    }
}
