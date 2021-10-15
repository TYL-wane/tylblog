package com.example.blogdemo.controller;

import com.example.blogdemo.util.CookieUtil;
import com.example.blogdemo.vo.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ExitLoginController {
    private CookieUtil cookieUtil;
    @RequestMapping("/exit")
    public RespBean exitUser(HttpServletRequest request, HttpServletResponse response){
        cookieUtil.deleteCookie(request,response,"userTicket");
        request.getSession().removeAttribute("user");
        if(request.getSession().getAttribute("user") == null){
            return RespBean.success();
        }
        return RespBean.error();
    }
}
