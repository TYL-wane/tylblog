package com.example.blogdemo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
@PropertySource("classpath:application.yaml")
@Data
public class FileUploadProperties {
    //对外暴露的资源
    private String staticAccessPath;
    //路径
    private String uploadFolder;
}
