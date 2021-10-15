package com.example.blogdemo.service;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.returndata.ArticleAllData;

import java.util.List;

/**
 * 该类是博客主页的业务方法
 * */
public interface ArticleService {
    //拿到所有的article内容
    ArticleAllData newArticle();
    /**
     * 通过id查询博文
     * */
    Article selectOneArticle(Integer artId);
    /**
     * 用来做所有博文的查询
     * */
    List<Article> selectAllArticle(int page,int limit);
    /**
     * 查询总数量
     * */
    int selectArticleCount();
}
