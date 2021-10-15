package com.example.blogdemo.vo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 该类用来返回公共的数据
 * */
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    //状态码
    private Integer code;
    //信息
    private String massage;
    //返回对象
    private Object obj;


    /**
     * 设计一个方法返回成功的结果 不带对象返回数据
     */
    public static RespBean success(){
        return  new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMassage(),null);
    }
    /**
      *  设计一个方法返回成功的结果 带对象返回数据
     */
    public static RespBean success(Object obj){
        return  new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMassage(),obj);
    }

    /**
     * 设计一个方法用来做错误的信息返回 不带对象返回数据
     * */
    public static RespBean error(){
        return new RespBean(RespBeanEnum.ERROR.getCode(), RespBeanEnum.ERROR.getMassage(), null);
    }
    /**
     * 设计一个方法用来做错误的信息返回  带对象返回数据
     * */
    public static RespBean error(RespBeanEnum obj){
        return new RespBean(obj.getCode(), obj.getMassage(), obj);
    }


}
