package com.example.blogdemo.vo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 添加评论接收参数
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentVo {
    private Integer artId;
    private Integer uId;
    private Integer commId;
    private Integer parentId;
    private String commContent;
}
