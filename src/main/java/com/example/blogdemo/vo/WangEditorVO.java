package com.example.blogdemo.vo;

import lombok.Data;

/**
 * 封装wangEditorVO类
 * 说必要也是有原因的，首先当我们上传图片后，
 * server会返回一个带有格式的数据（点击官网查看），
 * 即{"errno":0,"data":"地址1","地址2","..."}，
 * 这就需要我们定义一个wangEditorVO类，用来封装其返回的数据。
 * */
@Data
public class WangEditorVO {
    private Integer errno;
    private Object data;
    /**
     * 上传成功
     * */
    public static WangEditorVO success(Object data) {
        WangEditorVO wangEditorVO = new WangEditorVO();
        wangEditorVO.errno = 0;
        wangEditorVO.data = data;
        return wangEditorVO;
    }
    /**
     * 上传失败
     * */
    public static WangEditorVO error(Integer errno, Object data) {
        WangEditorVO wangEditorVO = new WangEditorVO();
        wangEditorVO.errno = errno;
        wangEditorVO.data = data;
        return wangEditorVO;
    }

}
