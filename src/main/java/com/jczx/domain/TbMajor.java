package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 专业表
 * @author 池炯武
 * @create 2019-11-20 14:51
 */
@Component
public class TbMajor extends Domain {
    private Integer id;
    private String name; //专业名称
    private String grade; //学年

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
