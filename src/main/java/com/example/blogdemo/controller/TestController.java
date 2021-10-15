package com.example.blogdemo.controller;

import com.example.blogdemo.pojo.Comments;
import com.example.blogdemo.pojo.User;
import com.example.blogdemo.returndata.CommentData;
import com.example.blogdemo.service.CommentService;
import com.example.blogdemo.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CommentService commentService;
    @RequestMapping("/test")
    public List<CommentData> test(){
        List<CommentData> comments = commentService.selectComments(16);

//        User user = new User();
//        user.setUserName("张三");
//        ValueOperations ops = redisTemplate.opsForValue();
//
//        ops.set("user", JSONUtil.object2JsonStr(user));
//
//        System.out.println(JSONUtil.jsonStr2Object((String) ops.get("user"),User.class));
        return comments;
    }
}
