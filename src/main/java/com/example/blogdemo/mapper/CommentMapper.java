package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.Comments;
import com.example.blogdemo.returndata.CommentData;
import com.example.blogdemo.returndata.ReplyData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论mapper
 * */
@Mapper
@Repository
public interface CommentMapper {
    /**
     * 根据博文id查询该博文下的所有评论
     * */
    CommentData selectComments(@Param("commId") Integer commId);
    /**
     * 查询所有的父评论id
     * */
    List<Integer> getCommentIdByBlogId(@Param("artId") Integer artId);

    List<ReplyData> selectByPid(@Param("parentCommId") Integer parentCommId);
}
