package com.example.blogdemo.service;

import com.example.blogdemo.vo.LoginVo;
import com.example.blogdemo.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  用户登录业务层
 * */
public interface LoginService {
    /**
     * 用户登录方法
     * */
   RespBean login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
}
