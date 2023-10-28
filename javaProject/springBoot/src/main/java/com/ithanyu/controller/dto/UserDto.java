package com.ithanyu.controller.dto;

import lombok.Data;

/**
 * @ClassName UserDto
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

/**
 * 接收前端登录请求参数
 */
@Data
public class UserDto {
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;
    private String token;
}
