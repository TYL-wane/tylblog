package com.example.blogdemo.controller;

import com.example.blogdemo.service.AddCommentService;
import com.example.blogdemo.vo.AddCommentVo;
import com.example.blogdemo.vo.RespBean;
import com.example.blogdemo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论添加接口
 * */
@RestController
public class AddCommentController {
    @Autowired
    private AddCommentService addCommentService;
    @RequestMapping("/addComment")
    public RespBean addComment(AddCommentVo addCommentVo){
//        System.out.println(addCommentVo);
        return addCommentService.addComment(addCommentVo);
    }
}
