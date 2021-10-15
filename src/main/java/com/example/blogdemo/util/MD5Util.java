package com.example.blogdemo.util;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * md5加密工具类
 * */
@Component
public class MD5Util {
    //设计一个方法用来做密码加密
    public static  String passwordEncryption(String src){
        return DigestUtils.md5Hex(src);
    }
    //加密的盐
    private static final String salt = "1a2b3c4b";
    //设计一个方法用来做第一次加密
    public static String inputPasswordEncryption(String inputPassword){
        String str = ""+salt.charAt(0)+salt.charAt(2) + inputPassword +salt.charAt(5) + salt.charAt(4);
        return passwordEncryption(str);
    }
    //设计一个方法用来做第二次加密
    public static String formatPasswordEncryption(String inputPassword,String salt){
        String str = ""+salt.charAt(0)+salt.charAt(2) + inputPassword +salt.charAt(5) + salt.charAt(4);
        return passwordEncryption(str);
    }

    //设计一个方法用来做整合加密
    public static String inputPassToFormatePass(String inputPassword,String salt){
        //调用一次加密
        String oneEncryption = inputPasswordEncryption(inputPassword);
        //第二次加密
        return formatPasswordEncryption(oneEncryption,salt);
    }
}
