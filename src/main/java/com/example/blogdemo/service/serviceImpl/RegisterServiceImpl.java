package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.pojo.User;
import com.example.blogdemo.mapper.RegisterMapper;
import com.example.blogdemo.service.RegisterService;
import com.example.blogdemo.util.MD5Util;
import com.example.blogdemo.vo.RegisterVo;
import com.example.blogdemo.vo.RespBean;
import com.example.blogdemo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Override
    public RespBean insertUserinfo(RegisterVo registerVo) {
        //检查是否昵称重复
        User nicknameuser = registerMapper.chickUserNickname(registerVo.getNickname());
        //查询是否账号重复
        User uname = registerMapper.chickUserName(registerVo.getUsername());
        if(nicknameuser !=null){
            return RespBean.error(RespBeanEnum.REGISTER_NICKNAME);
        }
        if(uname!=null){
            return RespBean.error(RespBeanEnum.REGISTER_UNAME);
        }
        //进行用户信息存储
        //对密码进行加密
        registerVo.setRepassword(MD5Util.inputPassToFormatePass(registerVo.getRepassword(),"1a2b3c4d"));
       int result =  registerMapper.insertUserinfo(registerVo);
        if(result == 1){
            return RespBean.success();
        }
        return RespBean.error(RespBeanEnum.REGISTER_BAI);
    }
}
