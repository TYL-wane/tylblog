package com.example.blogdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 该类用来做登录参数请求接收用的类
 * */
@Data
@AllArgsConstructor
public class LoginVo {
    @NotNull
    private String username;
    @NotNull
    private String password;


}
