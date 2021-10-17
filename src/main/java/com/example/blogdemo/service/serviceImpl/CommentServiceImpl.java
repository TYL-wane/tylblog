package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.mapper.CommentMapper;
import com.example.blogdemo.mapper.LoginMapper;
import com.example.blogdemo.pojo.Comments;
import com.example.blogdemo.pojo.User;
import com.example.blogdemo.returndata.CommentData;
import com.example.blogdemo.returndata.ReplyData;
import com.example.blogdemo.service.CommentService;
import com.example.blogdemo.service.LoginService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * 评论业务层
 * */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private LoginMapper userMapper;

    @Override
    public List<CommentData> selectComments(Integer artId) {
        List<CommentData> result = new ArrayList<>();
        //查找所有父评论id
        List<Integer> commentIdByBlogId = commentMapper.getCommentIdByBlogId(artId);
        for (Integer commId : commentIdByBlogId) {
            //拿到一个父评论
            CommentData commentData = commentMapper.selectComments(commId);
            //查找所有父级评论下的子评论
            List<ReplyData> replyVos = commentMapper.selectByPid(commentData.getCommId());
            List<ReplyData> reply = new ArrayList<>();
            for (ReplyData replyVo : replyVos) {
                //添加被回复的用户名
                User user = userMapper.selectOntUser(replyVo.getPareantUserId());
                replyVo.setParentUserImg(user.getUserImg());
                replyVo.setParentUserNickname(user.getUserNickname());
                reply.add(replyVo);

            }
            commentData.setChild(reply);
            result.add(commentData);

        }
        return result;

    }

    @Override
    public int selectCommentSize(Integer artId) {
        return commentMapper.selectCommentSize(artId);
    }
}
