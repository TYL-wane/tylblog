package com.example.blogdemo.mapper;

import com.example.blogdemo.returndata.UserArticleThumbs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * 添加用户点赞博文信息
 * */
@Mapper
@Repository
public interface ArticleThumbsMapper {
    /**
     * 添加用户点赞博文信息
     * */
    int addArticleThumbs(@Param("artId") Integer artId,@Param("uId") Integer uId);
    /**
     * 删除用户点赞博文信息
     * */
    int deleteArticleThumbs(@Param("artId") Integer artId,@Param("uId") Integer uId);

    /**
     * 查询是否点赞
     * */

    UserArticleThumbs selectThumbs(@Param("artId") Integer artId,@Param("uId") Integer uId);
}
