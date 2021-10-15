package com.example.blogdemo.vo;

import lombok.Data;
/**
 *  用户注册接收参数
 * */
@Data
public class RegisterVo {
    private String nickname;
    private String username;
    private String repassword;
    private String email;
}
