package com.example.blogdemo.returndata;

import com.example.blogdemo.pojo.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ArticleAllData {
    private List<Article> newArticle;//最近发表的文章
    private List<Article> moodEssayArticle;//心情随笔
    private List<Article> intervievArticle;//面试题
    private List<Article> erroNoteArticle;//错误笔记
}
