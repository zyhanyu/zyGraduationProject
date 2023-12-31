package com.ithanyu.service;

import com.ithanyu.controller.dto.UserDto;
import com.ithanyu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyhanyu
 * @since 2023-10-25
 */

public interface IUserService extends IService<User> {

    UserDto login(UserDto userDto);

    User register(UserDto userDto);
}
