package com.example.blogdemo.service;

import com.example.blogdemo.vo.AddCommentVo;
import com.example.blogdemo.vo.RespBean;

/**
 * 评论添加service
 * */
public interface AddCommentService {
    /**
     * 添加评论
     * */
    RespBean addComment(AddCommentVo addCommentVo);
}
