package com.example.blogdemo.service;

import com.example.blogdemo.pojo.DocumentType;

import java.util.List;
/**
 * 用来做博文种类的查询
 * */
public interface ArticleSortService {
    /**设计一个方法用来做 文章和类型的匹配*/
    List<DocumentType> selectAllDocumentType();
}
