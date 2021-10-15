package com.example.blogdemo.service.serviceImpl;

import com.example.blogdemo.configuration.FileUploadProperties;
import com.example.blogdemo.service.FileUploadService;
import com.example.blogdemo.vo.WangEditorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileUploadProperties fileUploadProperties;
//    private String imgPuth= null ;
    private static final String SERVER_PREFIX = "http://localhost:8081/uploadBlogImg/";
    @Override
    public WangEditorVO handleFileUpload(MultipartFile[] file) throws IOException {
        //当file为空时
        if (file == null || file.length == 0) {
            return WangEditorVO.error(500, "无图片信息");
        }

        //获取jar包所在目录
//        ApplicationHome h = new ApplicationHome(getClass());
//        File jarF = h.getSource();
//        //在jar包所在目录下生成一个upload文件夹用来存储上传的图片
//         imgPuth = jarF.getParentFile().toString()+"/upload/";

        //存入数据库的文件地址集合
        List<String> pathList = new ArrayList<>();
        for (MultipartFile multipartFile : file) {
            //获取文件名
            String name = UUID.randomUUID().toString();
            //拼接完整的 存放图片地址，即：D:\\IO\\shop\\shopImage\\文件名.后缀名
            File filePath = new File(fileUploadProperties.getUploadFolder() + name + getSuffix(multipartFile));
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            //将图片存放到path路径下
            multipartFile.transferTo(filePath);
            //拼接完整的 访问图片地址，即：http://localhost:8888/文件名.后缀名
            pathList.add(SERVER_PREFIX + name + getSuffix(multipartFile));
        }

        return WangEditorVO.success(pathList);

    }
    /**
     * 获取文件的后缀名
     *
     * @param multipartFile 上传的文件
     * @return 文件的后缀名
     */
    private String getSuffix(MultipartFile multipartFile) {
        //获取完整的文件名
        String fileName = multipartFile.getOriginalFilename();
        //截取后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        return fileSuffix;
    }
}
