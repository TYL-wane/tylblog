package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.mapper.AddCommentMapper;
import com.example.blogdemo.service.AddCommentService;
import com.example.blogdemo.vo.AddCommentVo;
import com.example.blogdemo.vo.RespBean;
import com.example.blogdemo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCommentServiceImpl implements AddCommentService {
    @Autowired
    private AddCommentMapper addCommentMapper;
    @Override
    public RespBean addComment(AddCommentVo addCommentVo) {
        if(addCommentVo.getUId() == null || addCommentVo.getParentId() == null || addCommentVo.getParentId()==null || addCommentVo.getCommContent() == null || addCommentVo.getCommId() == null){
            //直接添加失败
            return RespBean.error(RespBeanEnum.ADDCOMMENT);
        }
        //进行添加
        int i = addCommentMapper.addComment(addCommentVo);
       if(i>0){
        return RespBean.success();
       }
        return RespBean.error(RespBeanEnum.ADDCOMMENT);
    }
}
