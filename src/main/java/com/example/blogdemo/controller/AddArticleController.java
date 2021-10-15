package com.example.blogdemo.controller;

import com.example.blogdemo.service.AddArticleService;
import com.example.blogdemo.vo.AddArticleVo;
import com.example.blogdemo.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddArticleController {
    @Autowired
    private AddArticleService articleService;
    @RequestMapping("/addArticle")
    public RespBean addArticle(HttpServletRequest request,AddArticleVo addArticleVo){
        return articleService.addArticle(addArticleVo);
    }
}
