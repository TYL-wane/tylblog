package com.example.blogdemo.service;

import com.example.blogdemo.vo.AddArticleVo;
import com.example.blogdemo.vo.RespBean;
/**
 * 用来做博文的添加
 * */
public interface AddArticleService {
    /**
     * 博文添加方法
     * */
    RespBean addArticle(AddArticleVo addArticleVo);
}
