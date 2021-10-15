package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.mapper.ArticleClassifiationMapper;
import com.example.blogdemo.mapper.ArticleMapper;
import com.example.blogdemo.mapper.ArticleSortMapper;
import com.example.blogdemo.service.AddArticleService;
import com.example.blogdemo.service.FileUploadService;
import com.example.blogdemo.vo.AddArticleVo;
import com.example.blogdemo.vo.RespBean;
import com.example.blogdemo.vo.RespBeanEnum;
import com.example.blogdemo.vo.WangEditorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AddArticleServiceImpl implements AddArticleService {
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleSortMapper articleSortMapper;
    @Autowired
    private ArticleClassifiationMapper articleClassifiationMapper;
    @Override
    public RespBean addArticle(AddArticleVo addArticleVo) {
        //先进行图片的处理
        WangEditorVO wangEditorVO = null;
        try {
            wangEditorVO = fileUploadService.handleFileUpload(addArticleVo.getArticleImg());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //拿到图片上传的路径
        String imagePath = wangEditorVO.getData().toString();
        //[http://localhost:8081/upload/062a3192-db74-40f8-a872-ea3ab166bdf9.png]把[]去掉
        String newImagePath = imagePath.substring(imagePath.indexOf("[")+1,imagePath.length()-1);
        //放入addArticleVo  img
        addArticleVo.setImg(newImagePath);
        //进行博文的添加
        int result = articleMapper.addArticle(addArticleVo);
        if(result == 1){
            //添加成功
            //拿到博文添加返回的artId
            Integer artId = addArticleVo.getArtId();
            System.out.println("artId:"+artId);
            if(!addArticleVo.getArticleClassiId().isEmpty()){
                //添加classification
                articleClassifiationMapper.addClassification(artId,Integer.parseInt(addArticleVo.getArticleClassiId()));
            }
            //拿到博文分类的String(1,2)
            String articleDocId = addArticleVo.getArticleDocId();
            //判断它的长度是否>1
            if(!articleDocId.isEmpty()){

                if(articleDocId.length()>1){
                    //有两个标签（1,2） 进行拆分
                    String[] docIds = articleDocId.split(",");
                    for (String docId : docIds) {
                        int resultDocId = articleSortMapper.addArticleSort(artId, Integer.parseInt(docId));
                    }

                }else{
                    //只有一个标签
                    int resultDocId = articleSortMapper.addArticleSort(artId, Integer.parseInt(articleDocId));
                }

            }

            return RespBean.success(RespBeanEnum.ADDARTICLESUCCESS);

        }

        return RespBean.error(RespBeanEnum.ADDARTICLEERRO);
    }
}
