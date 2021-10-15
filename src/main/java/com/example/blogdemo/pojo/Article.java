package com.example.blogdemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 该类是用来做博客文章的查询
*/
@Data
@JsonIgnoreProperties(value = { "handler"})
@ApiModel("博客文章内容")
public class Article {
    @ApiModelProperty("文章id")
    private Integer artId;
    @ApiModelProperty("创建时间")
    private String artTime;//创建时间
    private String artContent;//文章内容
    private String artDescribe;
    private String artTitle;//文章标题
    private String aetImg;//展示图片
    private String artUpdateTime;//修改时间
    private Integer artThumbsSize;//点赞数量
    private Integer artBrowseSize;//浏览数量
    private String artKeyword;//关键字
    private Integer artCommentsSize;//评论数量
    private List<Classification> classifications;
    private List<DocumentType> documentTypes;
}
