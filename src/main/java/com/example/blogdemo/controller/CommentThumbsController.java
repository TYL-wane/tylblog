package com.example.blogdemo.controller;

import com.example.blogdemo.vo.RespBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 评论点赞controller
 * */
@Controller
public class CommentThumbsController {
    @RequestMapping("/onCommentThumbs")
    public RespBean addCommentThumbs(@Param("uId")String uId,@Param("artId")String artId,@Param("commId")String commId){
        return RespBean.success();
    }
}
