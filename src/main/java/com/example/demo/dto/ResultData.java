package com.example.demo.dto;

import lombok.Data;

@Data
public class ResultData {

    /**
     * code : 0
     * msg : 管理员登录成功
     * data : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJOYW1lIjoibm1qeXB4eHQiLCJVc2VyTmFtZSI6IuWugeeFpOaVmeiCsuWfueiureezu-e7nyIsIlVzZXJJZCI6IkE2MDU5RDZGLTIwQjktNDVFNS04ODUxLTg4MUI3MUQyQTA2MiIsIkhhbmRObyI6bnVsbCwiRGVwdElkIjpudWxsLCJJc1N1cGVyQWRtaW4iOmZhbHNlLCJleHAiOjE1NjU4NTI4NzAuMCwiRGVmYXVsdFBhZ2UiOm51bGx9.vHW82kw4rFT-4vlmmV5glGQfABuGnbcUXAvtNx1B5b1Nydo9Ur9nThMFY3DxmIX2EPBOUMsD_BGmmLXKe_J14w
     */

    private int code;
    private String msg;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
