package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.mapper.ArticleMapper;
import com.example.blogdemo.mapper.ArticleThumbsMapper;
import com.example.blogdemo.returndata.UserArticleThumbs;
import com.example.blogdemo.service.ArticleThumbsSizeService;
import com.example.blogdemo.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleThumbsSizeServiceImpl implements ArticleThumbsSizeService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleThumbsMapper articleThumbsMapper;
    @Override
    public RespBean onArtThumbsSize(Integer artId,Integer uId) {
        //博文点赞
        int  result = articleMapper.onArtThumbsSize(artId);
        //判断
        if(result == 1){
            //添加点赞信息
            if(articleThumbsMapper.addArticleThumbs(artId,uId) == 1);
            return RespBean.success();
        }
        return RespBean.error();
    }

    @Override
    public RespBean outArtThumbsSize(Integer artId,Integer uId) {
        //博文点赞
        int  result = articleMapper.outArtThumbsSize(artId);
        System.out.println("out"+result);
        //判断
        if(result == 1){
            //删除点赞信息
            if(articleThumbsMapper.deleteArticleThumbs(artId,uId)==1);
            return RespBean.success();
        }
        return RespBean.error();
    }

    @Override
    public UserArticleThumbs selectThumbs(Integer artId, Integer uId) {
        return articleThumbsMapper.selectThumbs(artId,uId);
    }
}
