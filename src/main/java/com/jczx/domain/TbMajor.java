package com.jczx.domain;

import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 专业表
 * @author 池炯武
 * @create 2019-11-20 14:51
 */
@Component
public class TbMajor extends Domain {
    @NotCreate
    public static final int TYPE_MAJOR=0;
    @NotCreate
    public static final int TYPE_SCHOOL_YEAR=1;
    private Integer id;
    private String name; //专业名称
    private String pid; //学年换pid父类在同一表//专业,班级//加type//备注
    private Integer type;//类型，区分班级和专业
    private String remark;//备注

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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
}
