package com.ithanyu.exception;

/**
 * @ClassName ServiceException
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException{
    private String code;

    public ServiceException(String code,String msg){
        super(msg);
        this.code = code;
    }
}
