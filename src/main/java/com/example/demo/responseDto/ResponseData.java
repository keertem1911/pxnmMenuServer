package com.example.demo.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author 王传鑫
 * @Date 2019/7/19
 */
@Data
public class ResponseData<T> implements Serializable {
    private int code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;
    public static ResponseData success(){
        return new ResponseData(0,"success");
    }
    public static <T>ResponseData success(T data){
        return new ResponseData<>(0,"success",data);
    }
    public static ResponseData<String> error(String msg){
        return new ResponseData<>(100,msg);
    }
    public static ResponseData error(int code,String msg){
        return new ResponseData(code,msg);
    }

    private ResponseData(){};
    private ResponseData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
