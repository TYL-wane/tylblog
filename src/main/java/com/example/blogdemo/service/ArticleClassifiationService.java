package com.example.blogdemo.service;

import com.example.blogdemo.pojo.Classification;

import java.util.List;

/**
 * 博文分类业务层
 * */
public interface ArticleClassifiationService {
    /**
     * 获取所有的博文分类信息
     * */
    List<Classification> selectAllClassifiation();
}
