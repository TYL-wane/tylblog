package com.example.blogdemo.controller;

import com.example.blogdemo.returndata.ArticleAllData;
import com.example.blogdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/artcile")
    public ArticleAllData test(){
        //拿到数据
       ArticleAllData articleData = articleService.newArticle();
        return articleData;
    }
    @RequestMapping("/selectAllArticle")
    public Map<String,Object>  articles(@RequestParam("page")String page,@RequestParam("limit")String limit){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("message","");
        resultMap.put("count",articleService.selectArticleCount());
        resultMap.put("data",articleService.selectAllArticle(Integer.parseInt(page),Integer.parseInt(limit)));
        return resultMap;
//        return
    }
}
