package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.vo.AddArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ArticleMapper {
    //设计一个方法用来做新发布博客文章的查询
    List<Article> newArticle() ;
    //用来做心情随笔的文章查询
    List<Article> moodEssayArticle();
    //用来做面试题文章的查询
    List<Article> intervievArticle();
    //用来做错误笔记的文章的查询
    List<Article> erroNoteArticle();
    /**
     *  根据id查询博文
     * */
    Article selectOneArticle(@Param("artId") Integer artId);
    /**
     * 查询所有的博文
     * */
    List<Article> selectAllArticle(@Param("page") int page,@Param("limit") int limit);
    /**
     * 查询总数量
     * */
    int selectArticleCount();

    /**
     * 添加博文信息
     * */
    int addArticle(AddArticleVo addArticleVo);
}
