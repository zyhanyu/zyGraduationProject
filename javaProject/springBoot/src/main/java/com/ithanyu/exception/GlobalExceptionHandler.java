package com.ithanyu.exception;

import com.ithanyu.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ClassName ExceptionHandler
 * @Description: TODO
 * @Author:1276046082@qq.com
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 如果抛出的是ServiceException，则调用该方法
     * @param se 业务异常
     * @return Result
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException se){
        return Result.error(se.getCode(),se.getMessage());
    }
}
