package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.User;
import com.example.blogdemo.vo.RegisterVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户注册mapper类
 * */
@Mapper
@Repository
public interface RegisterMapper {
    /**
     * 设计一个方法用来做用户注册昵称验证
     * */
    User chickUserNickname(@Param("nickname") String userNickname);
    /**
     * 设计一个方法用来做用户账号的验证
     * */
    User chickUserName(@Param("uname") String userName);
    /**
     * 设计一个方法用来做用户注册信息的存储
     * */
    int insertUserinfo(RegisterVo registerVo);
}
