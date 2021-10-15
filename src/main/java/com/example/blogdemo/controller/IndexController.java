package com.example.blogdemo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    @ApiOperation("去主页")
    public String testUser(){
        return "index";
    }
    @RequestMapping("/toIndex")
    public  String toIndex(){
        return "index";
    }

}
