package com.example.blogdemo.controller;

import com.example.blogdemo.service.FileUploadService;
import com.example.blogdemo.vo.WangEditorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @RequestMapping("/wangUpload")
    public WangEditorVO wangUpload(@RequestPart("file") MultipartFile[] file) throws IOException {

        return fileUploadService.handleFileUpload(file);
    }
}
