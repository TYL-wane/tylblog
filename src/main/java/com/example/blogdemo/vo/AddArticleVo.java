package com.example.blogdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 *哟用来接收添加博文参数的vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleVo {
    private Integer artId; //博文id
    private String articleTitle;//博文标题
    private String articleContent;//博文内容
    private String articleKeywords;//关键字
    private String articleDescribe;//描述
    private String articleClassiId;//分类id
    private String articleDocId;//博文板块id
    private MultipartFile[] articleImg;//上传图片MiltipartFile对象

    private String img;//展示图片路径
}
