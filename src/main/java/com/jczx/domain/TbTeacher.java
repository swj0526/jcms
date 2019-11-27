package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 老师表
 *
 * @author 池炯武
 * @create 2019-11-20 14:41
 */
@Component
public class TbTeacher extends Domain {

    private Integer id;
    private String name;//姓名
    private String gender;//性别
    private String phone;//手机号
    private Boolean hasQuit;//老师状态
    private Integer operatorId;//操作人
    private Date createTime;//操作时间


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getHasQuit() {
        return hasQuit;
    }

    public void setHasQuit(Boolean hasQuit) {
        this.hasQuit = hasQuit;
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
