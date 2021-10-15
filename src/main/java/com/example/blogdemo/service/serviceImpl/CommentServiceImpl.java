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
 * 评论业务
 * */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private LoginMapper userMapper;

    public void selectComments12(Integer artId) {
//        List<Comments> allComments = commentMapper.selectComments(artId);
//        if (allComments == null || allComments.size() == 0) {
//            return new ArrayList<>();
//        }
//        List<Comments> comments = new ArrayList<>();
//        //用来装父评论
//        List<Comments> parents = new ArrayList<>();
//        for (Comments comment : allComments) {
//            //判断是否有父评论
//            if (comment.getCommParentid()==null) {
//
//                comments.add(comment);
//                parents.add(comment);
//            } else {
//                boolean foundParent=false;
//                //循环父list
//                for (Comments parent : parents) {
//                    //用所有的comment拿到父评论id  与 评论的id进行对比
//                    if (comment.getCommParentid() == parent.getCommId()) {
//                        //判断是否有子评论
//                        if (parent.getChild() == null) {
//                            //添加一个子评论
//                            parent.setChild(new ArrayList<>());
//                        }
//                        //如果判断的是有parentcommId == connId
//                        //添加一个子评论
//                        parent.getChild().add(comment);
//                        parents.add(comment);
//                        foundParent=true;
//                        //如果对list迭代过程中同时修改list，会报java.util.ConcurrentModificationException
//                        // 的异常，所以我们需要break,当然break也可以提高算法效率
//                        break;
//                    }
//                }
//                if (!foundParent) {
//                    throw new RuntimeException("can not find the parent comment");
//                }
//            }
//        }
//        return comments;
    }

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
}
