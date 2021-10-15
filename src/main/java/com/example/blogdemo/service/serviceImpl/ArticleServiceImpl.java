package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.mapper.ArticleMapper;
import com.example.blogdemo.returndata.ArticleAllData;
import com.example.blogdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleAllData newArticle() {
        //拿到新发布的文章 取前六个
        List<Article> newArticles = new ArrayList<>();
        List<Article> articles = articleMapper.newArticle();
        int m = articles.size();
        for (int i=0;i<m;i++){
            newArticles.add(articles.get(i));
        }
        return new ArticleAllData(newArticles, articleMapper.moodEssayArticle(), articleMapper.intervievArticle(), articleMapper.erroNoteArticle());
    }

    @Override
    public Article selectOneArticle(Integer artId) {
        return articleMapper.selectOneArticle(artId);
    }

    @Override
    public List<Article> selectAllArticle(int page,int limit) {
        int pages = (page-1)*limit;
        return articleMapper.selectAllArticle(pages,limit);
    }

    @Override
    public int selectArticleCount() {
        return articleMapper.selectArticleCount();
    }


}
