package com.example.blogdemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置文件上传路径
 * */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private FileUploadProperties fileUploadProperties;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取jar包所在目录
//        ApplicationHome h = new ApplicationHome(getClass());
//        File jarF = h.getSource();
        //在jar包所在目录下生成一个upload文件夹用来存储上传的图片
        //jarbao:D:\blog\tylblog\blogdemo\target/upload/
//        String imgPuth = jarF.getParentFile().toString()+"/upload/";
        registry.addResourceHandler(fileUploadProperties.getStaticAccessPath()).addResourceLocations("file:/"+fileUploadProperties.getUploadFolder());

    }
}
