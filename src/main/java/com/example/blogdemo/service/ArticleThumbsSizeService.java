package com.example.blogdemo.service;

import com.example.blogdemo.returndata.UserArticleThumbs;
import com.example.blogdemo.vo.RespBean;
import io.swagger.models.auth.In;

/**
 * 博文点赞业务层
 * */
public interface ArticleThumbsSizeService {
    /**博文点赞*/
    RespBean onArtThumbsSize(Integer artId,Integer uId);
    /**
     * 博文取消点赞
     * */
    RespBean outArtThumbsSize(Integer artId,Integer uId);

    /**
     * 查询用户点赞信息
     * */
    UserArticleThumbs selectThumbs(Integer artId,Integer uId);
}
