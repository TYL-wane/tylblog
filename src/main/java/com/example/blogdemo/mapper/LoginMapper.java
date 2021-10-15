package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.User;
import com.example.blogdemo.vo.LoginVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 *  用户登录访问层
 * */

@Mapper
@Repository
public interface LoginMapper {
    /**
     * 用户登录查询方法
     * */
    User loginUser(LoginVo loginVo);
    User selectOntUser(@Param("userId")Integer u_id);
}
