package com.example.blogdemo.mapper;

import com.example.blogdemo.vo.AddCommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * 评论添加mapper
 * */
@Mapper
@Repository
public interface AddCommentMapper {
    /**
     * 添加评论
     * */
    int addComment(AddCommentVo addCommentVo);
}
