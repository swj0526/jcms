package com.jczx.domain;

import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 老师表
 * @author 池炯武
 * @create 2019-11-20 14:41
 */
@Component
public class TbTeacher extends Domain {
//    @NotCreate
//    public static final int STATE_OFFICE=0;
//    @NotCreate
//    public static final int STATE_NOT_OFFICE=1;

    private Integer id;
    private String name;
   // private  Integer majorId;//班级
    private String phone;//手机号
    private Integer state;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
