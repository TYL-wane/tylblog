package com.example.blogdemo.controller;

import com.example.blogdemo.service.ArticleThumbsSizeService;
import com.example.blogdemo.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleThumbsSizeController {
    @Autowired
    private ArticleThumbsSizeService articleThumbsSizeService;
    //博文点赞
    @RequestMapping("/onArtThumbsSize")
    public RespBean onArtThumbsSize(@RequestParam("artId") String artId,@RequestParam("uId")String uId){

        return articleThumbsSizeService.onArtThumbsSize(Integer.parseInt(artId),Integer.parseInt(uId));
    }

    //博文取消点赞
    @RequestMapping("/outArtThumbsSize")
    public RespBean outArtThumbsSize(@RequestParam("artId") String artId,@RequestParam("uId")String uId){

        return articleThumbsSizeService.outArtThumbsSize(Integer.parseInt(artId),Integer.parseInt(uId));
    }
}
