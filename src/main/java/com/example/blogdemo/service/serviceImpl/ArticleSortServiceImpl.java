package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.pojo.DocumentType;
import com.example.blogdemo.mapper.ArticleSortMapper;
import com.example.blogdemo.service.ArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 用来查询博文种类
 * */
@Service
public class ArticleSortServiceImpl implements ArticleSortService {
    @Autowired
    private ArticleSortMapper articleSortMapper;
    @Override
    public List<DocumentType> selectAllDocumentType() {
        return articleSortMapper.selectAllDocumentType();
    }
}
