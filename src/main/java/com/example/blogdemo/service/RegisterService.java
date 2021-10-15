package com.example.blogdemo.service;

import com.example.blogdemo.vo.RegisterVo;
import com.example.blogdemo.vo.RespBean;

/**
 * 用户注册业务类
 * */
public interface RegisterService {

    /**
     * 设计一个方法用来做用户注册信息的存储
     * */
    RespBean insertUserinfo(RegisterVo registerVo);
}
