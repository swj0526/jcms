package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 老师表
 * @author cjw
 * @create 2019-11-20 14:41
 */
@Component
public class TbTeacher extends Domain {
    private Integer id;
    private String name;
    private  Integer majorId;//班级
    private String Phone;//手机号

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

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
