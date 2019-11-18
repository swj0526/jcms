package com.jczx.domain;

/**
 * @author swj
 * @description 用户表,用来登录跟盘算权限的
 * @create 2019-11-18 16:45
 */
public class TbUser {
    private  int id;
    private int type;//类型 1.学生 2.教职工
    private int accountId;//跟具体的信息表关联id
    private String phone;//手机号码,登录时的用户名
    private String password;//密码
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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