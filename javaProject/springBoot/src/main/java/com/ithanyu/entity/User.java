package com.ithanyu.entity;

import lombok.Data;

/**
 * @ClassName User
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
}
