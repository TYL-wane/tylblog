package com.example.blogdemo.exception;

import com.example.blogdemo.vo.RespBean;
import com.example.blogdemo.vo.RespBeanEnum;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 *
 .
 @ControllerAdvice方式只能处理控制器抛出的异常。此时请求已经进入控制器中。
 2.ErrorController类方式可以处理所有的异常，包括未进入控制器的错误，比如404,401等错误
 3.如果应用中两者共同存在，则@ControllerAdvice方式处理控制器抛出的异常，ErrorController类方式处理未进入控制器的异常。
 4.@ControllerAdvice方式可以定义多个拦截方法，拦截不同的异常类，并且可以获取抛出的异常信息，自由度更大。
 * */
//@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 该方法做异常判断
     * */
    @ExceptionHandler(Exception.class)
    public RespBean exceptionHandler(Exception e){
        if(e instanceof GlobalException){
           GlobalException ex =  (GlobalException)e;
           return RespBean.error(ex.getRespBeanEnum());
        }else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.VALIDATION);
                    respBean.setMassage("参数校验异常：" + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
