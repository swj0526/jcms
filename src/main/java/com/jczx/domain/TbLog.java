package com.jczx.domain;

/**
 * @author swj
 * @description 日志表
 * @create 2019-11-18 16:25
 */
public class TbLog {
    private int id;
    private int type;//操作类型 1.增加 2.删除 3.修改
    private String content; //操作内容
    private int operatorId;//操作人
    private String createTime;//操作时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}