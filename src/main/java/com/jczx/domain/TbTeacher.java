package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

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
}
