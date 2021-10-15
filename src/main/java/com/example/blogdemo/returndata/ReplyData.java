package com.example.blogdemo.returndata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户评论
 *
 * 评论用户信息.评论的内容
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyData {
    private Integer commId; //评论id
    private Integer artId;//博文id
    private Integer uId;//用户id
    private String userImg;//头像
    private String uNickname;//用户昵称
    private String commTime;//创建时间
    private String commContent;//评论内容
    private Integer commLikeNum;//喜欢的数量
    private Integer commNolikeNum;//不喜欢的数量
    private String parentUserImg;
    private String parentUserNickname;
    private Integer pareantUserId;
}
