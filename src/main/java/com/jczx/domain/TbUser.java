package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description 用户表,用来登录跟盘算权限的
 * @author 孙文举
 * @create 2019-11-18 16:45
 */
@Component
public class TbUser  extends Domain {
    private  Integer id;
    private Integer type;//类型 1.学生 2.教职工
    private Integer accountId;//跟具体的信息表关联id
    private String phone;//手机号码,登录时的用户名
    private String password;//密码
    private Integer operatorId;//操作人
    private Date createTime;//操作时间
//加enable,老师加状态 状态字典
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}