package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OperateJson  implements Serializable {

    private static final long serialVersionUID = 8168046979937231531L;


    /**
     * authzId : cf6ac8d035054575bd1e3fd977819c51
     * type : OPERATE
     * referencesId : null
     * id : 4a5687ad15664c5094d1e8ff1ddd4b67
     * text : 查看明细
     * pid : daf796fae21c405983911eb836dd0a33
     * orderIndex : 4
     * resourcePath : /system/user/load
     * allowAuthz : Y
     * remark : null
     * enabled : Y
     * code : OUTER_USER_VIEW
     * isLog : Y
     * icon : /insstatic/image/icon/config.png
     * leaf : true
     */
    private String authzId;
    private String type;
    private Object referencesId;
    private String id;
    private String text;
    private String pid;
    private double orderIndex;
    private String resourcePath;
    private String allowAuthz;
    private Object remark;
    private String enabled;
    private String code;
    private String isLog;
    private String icon;
    private boolean leaf;

    public String getAuthzId() {
        return authzId;
    }

    public void setAuthzId(String authzId) {
        this.authzId = authzId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getReferencesId() {
        return referencesId;
    }

    public void setReferencesId(Object referencesId) {
        this.referencesId = referencesId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public double getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(double orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getAllowAuthz() {
        return allowAuthz;
    }

    public void setAllowAuthz(String allowAuthz) {
        this.allowAuthz = allowAuthz;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsLog() {
        return isLog;
    }

    public void setIsLog(String isLog) {
        this.isLog = isLog;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
