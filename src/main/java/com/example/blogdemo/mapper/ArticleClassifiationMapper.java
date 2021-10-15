package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.Classification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 查询博文分类的 类
 * */
@Mapper
@Repository
public interface ArticleClassifiationMapper {
    /**
     * 获取所有的博文分类信息
     * */
    List<Classification> selectAllClassifiation();
    List<Classification> selectOneClassifiation(@Param("art_id")Integer artId);
    /**
     * 添加博文时添加博文分类分类信息
     * */
    int addClassification(@Param("artId") Integer artId,@Param("classiId") Integer classiId);
}
