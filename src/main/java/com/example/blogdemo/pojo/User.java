package com.example.blogdemo.pojo;

import lombok.Data;

@Data
public class User {
    private Integer userId;//用户id
    private String userName;//用户名
    private String userPassword;//用户密码
    private String userEmail;//邮箱
    private String userImg;//头像
    private String userRegistTime;//注册时间
    private String userBirthday;//生日
    private Integer userAge;//年龄
    private String userPhoneNumber;//电话号码
    private String userNickname;//昵称
    private String userSignature;//个性签名
    private String userProfilePhoto;
    private String userTegistrationTime;
}
