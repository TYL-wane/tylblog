package com.example.blogdemo.returndata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户点赞博文实体类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserArticleThumbs {
    private Integer atId;
    private Integer uId;
    private Integer artId;
}
