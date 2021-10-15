package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.pojo.Classification;
import com.example.blogdemo.mapper.ArticleClassifiationMapper;
import com.example.blogdemo.service.ArticleClassifiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleClassifiationServiceImpl implements ArticleClassifiationService {
    @Autowired
    private ArticleClassifiationMapper articleClassifiationMapper;
    @Override
    public List<Classification> selectAllClassifiation() {
        return articleClassifiationMapper.selectAllClassifiation();
    }
}
