package com.example.blogdemo.service;

import com.example.blogdemo.vo.WangEditorVO;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 处理图片的业务
 * */
public interface FileUploadService {
    WangEditorVO handleFileUpload(MultipartFile[] multipartFile) throws IOException;
}
