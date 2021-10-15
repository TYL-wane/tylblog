package com.example.blogdemo.controller;

import com.example.blogdemo.service.LoginService;
import com.example.blogdemo.service.RegisterService;
import com.example.blogdemo.service.serviceImpl.LoginServiceImpl;
import com.example.blogdemo.service.serviceImpl.RegisterServiceImpl;
import com.example.blogdemo.util.MD5Util;
import com.example.blogdemo.vo.LoginVo;
import com.example.blogdemo.vo.RegisterVo;
import com.example.blogdemo.vo.RespBean;
import com.example.blogdemo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private RegisterServiceImpl registerService;
    /**
     * 该方法用来接收用户登录的数据
     * */
    @RequestMapping("/login")
    public RespBean userLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
//        System.out.println(loginVo);
        return loginService.login(loginVo,request,response);
    }

    /**
     * 注册方法
     * */
    @RequestMapping("/toRegister")
    public RespBean userRegister(RegisterVo registerVo){
//        System.out.println("注册参数:"+registerVo.toString());

        return  registerService.insertUserinfo(registerVo);
    }
}
