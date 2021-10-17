package com.example.blogdemo.service;

import com.example.blogdemo.pojo.Comments;
import com.example.blogdemo.returndata.CommentData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论你service
 * */
public interface CommentService {
    /**
     * 根据博文id查询该博文下的所有评论
     * */
    List<CommentData> selectComments(Integer artId);

    /**
     * 查询评论条数
     * */
    int selectCommentSize(Integer artId);
}
