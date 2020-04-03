package com.example.demo.dto;

import lombok.Data;

import java.util.List;
@Data
public class PushLight {

    /**
     * PushType : 0
     * appID : 1000003
     * sendUser : 1000003
     * recvUser : [15000003,15000015]
     * type : 1
     * text : 内容
     * url : http://www.baidu.com/
     * img : sample string 7
     * time : 2018-12-27 14:19:41
     */

    private int PushType;
    private String appID;
    private int sendUser;
    private int type;
    private String text;
    private String url;
    private String img;
    private String time;
    private List<Integer> recvUser;

    public int getPushType() {
        return PushType;
    }

    public void setPushType(int PushType) {
        this.PushType = PushType;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public int getSendUser() {
        return sendUser;
    }

    public void setSendUser(int sendUser) {
        this.sendUser = sendUser;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Integer> getRecvUser() {
        return recvUser;
    }

    public void setRecvUser(List<Integer> recvUser) {
        this.recvUser = recvUser;
    }
}
