package com.example.blogdemo.mapper;

import com.example.blogdemo.pojo.DocumentType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleSortMapper {
    /**设计一个方法用来做 文章和类型的匹配*/
    List<DocumentType> selectDocumentType(@Param("art_id") Integer artId);
    /**
     * 查询所有种类
     * */
    List<DocumentType> selectAllDocumentType();

    int addArticleSort(@Param("artId") Integer artId,@Param("docId") Integer docId);
}
