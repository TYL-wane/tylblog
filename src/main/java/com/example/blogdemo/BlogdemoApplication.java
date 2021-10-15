package com.example.blogdemo;

import com.example.blogdemo.configuration.FileUploadProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.example.blogdemo.mapper")
@EnableConfigurationProperties({FileUploadProperties.class})
public class BlogdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogdemoApplication.class, args);
    }

}
