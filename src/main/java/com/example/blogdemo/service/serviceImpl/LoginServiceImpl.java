package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.pojo.User;
import com.example.blogdemo.exception.GlobalException;
import com.example.blogdemo.mapper.LoginMapper;
import com.example.blogdemo.service.LoginService;
import com.example.blogdemo.util.CookieUtil;
import com.example.blogdemo.util.MD5Util;
import com.example.blogdemo.util.UUIDUtil;
import com.example.blogdemo.vo.LoginVo;
import com.example.blogdemo.vo.RespBean;
import com.example.blogdemo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public RespBean login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("klklkl"+loginVo.toString());
        //根据用户登录信息查询用户是否存在
       User user = loginMapper.loginUser(loginVo);
       //判断用户是否存在
        if(user ==null){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        //判断密码是否正确
        if(!MD5Util.inputPassToFormatePass(loginVo.getPassword(),"1a2b3c4d").equals(user.getUserPassword())){
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        //uuid生成唯一的id
        String ticket = UUIDUtil.uuid();
        //创建session
        request.getSession().setAttribute(ticket,user);
        request.getSession().setAttribute("user",user);
        //创建cookie
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success(user);
    }

}
