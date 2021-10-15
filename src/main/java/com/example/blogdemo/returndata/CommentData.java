package com.example.blogdemo.returndata;

import com.example.blogdemo.pojo.Comments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 查询所有的评论返回的数据
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentData {
    private Integer commId; //评论id
    private Integer artId;//博文id
    private Integer uId;//用户id
    private String uNickname;//用户昵称
    private String userImg;
    private String commTime;//创建时间
    private String commContent;//评论内容
    private Integer commLikeNum;//喜欢的数量
    private Integer commNolikeNum;//不喜欢的数量
    private Integer commParentid;//父评论id
    private List<ReplyData> child;//子博文
}
