package com.example.blogdemo.controller;

import com.example.blogdemo.pojo.Classification;
import com.example.blogdemo.pojo.DocumentType;
import com.example.blogdemo.service.ArticleClassifiationService;
import com.example.blogdemo.service.ArticleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 做页面跳转
 * */
@Controller
public class AadminController {
    @Autowired
    private ArticleClassifiationService articleClassifiationService;
    @Autowired
    private ArticleSortService articleSortService;
    @RequestMapping("/toadmin")
    public String toAdmin(){
        //去后台主页
        return "adminhtml/indexAdmin";
    }
    @RequestMapping("/toWriteArticle")
    public String toWriteArticle(){
        //文章展示页面
        return "adminhtml/writeArticle";
    }
    @RequestMapping("/toWriteBlogArticle")
    public String toWriteBlogArticle(Model model){
        //书写文章
        //查询所有的博文分类信息
        List<Classification> classifications = articleClassifiationService.selectAllClassifiation();
        //查询所有的博文种类信息
        List<DocumentType> documentTypes = articleSortService.selectAllDocumentType();
        model.addAttribute("classifiations",classifications);
        model.addAttribute("documentTypes",documentTypes);
        return "adminhtml/writeBlogArticle";
    }

}
