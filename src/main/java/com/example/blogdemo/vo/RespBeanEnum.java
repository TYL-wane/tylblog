package com.example.blogdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 该类是返回公共对象的枚举enum
 * 一般用于  返回的状态码  massage信息
 * */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常"),
    //登录模块
    LOGIN_ERROR(500210,"用户名或密码错误"),
    //注册用户昵称重复
    REGISTER_NICKNAME(500,"用户昵称重复,请换一个用户昵称"),
    //注册用户账户重复
    REGISTER_UNAME(500,"账号重复啦,请换一个账号"),
    //注册失败
    REGISTER_BAI(500,"注册失败"),
    //数据校验
    VALIDATION(500,"数据校验错误"),
    //博文添加失败
    ADDARTICLESUCCESS(200,"博文添加成功"),
    ADDARTICLEERRO(500,"博文添加失败"),
    ADDCOMMENT(500,"评论失败，请检查评论信息");
    //定义状态码
    private final Integer code;
    //定义信息
    private final String massage;
}
