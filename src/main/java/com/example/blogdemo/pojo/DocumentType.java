package com.example.blogdemo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "handler"})
public class DocumentType {
    private Integer docId;
    private String docName;
}
