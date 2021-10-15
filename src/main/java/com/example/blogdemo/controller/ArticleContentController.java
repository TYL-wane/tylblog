package com.example.blogdemo.controller;

import com.example.blogdemo.pojo.Article;
import com.example.blogdemo.pojo.Comments;
import com.example.blogdemo.returndata.CommentData;
import com.example.blogdemo.service.ArticleService;
import com.example.blogdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品的内容控制类
 * */
@Controller
public class ArticleContentController {
    //商品的业务层
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @RequestMapping("/tocontent")
    public String testContent(@RequestParam("artid") String artId, Model model){
        //根据博文id查询博文
       Article article = articleService.selectOneArticle(Integer.parseInt(artId));
        //查询博文评论
        List<CommentData> commentData = commentService.selectComments(16);
//        System.out.println(article);
       //拿到当前的数据存入request
        model.addAttribute("article",article);
        model.addAttribute("comments",commentData);
        return "content";
    }

}
