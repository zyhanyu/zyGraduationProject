package com.ithanyu.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ithanyu.common.Constants;
import com.ithanyu.entity.User;
import com.ithanyu.exception.ServiceException;
import com.ithanyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName JwtInterceptor
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

// @Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        // 执行认证
        if (StrUtil.isBlank(token)){
            throw new ServiceException(Constants.CODE_401,"无token,重新登陆");

        }
        // 获取 token 中的 user id
        String userId;
        try {
            userId =  JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j){
            throw new ServiceException(Constants.CODE_401,"token验证失败,请重新登录");
        }
        // 根据token中的userid查询数据库.
        User user = userService.getById(userId);
        if (user == null){
                throw new RuntimeException("用户不存在，请重新登录");
            }
        // 用户密码加签验证token
        JWTVerifier jwtVerifiler = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifiler.verify(token); // 验证token
        }catch (JWTVerificationException e){
            throw new RuntimeException("token验证失败,请重新登录");
        }

        return true;
    }
}
