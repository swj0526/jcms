package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 孙文举
 * @description 权限表
 * @create 2019-12-24 18:08
 */
@Component
public class TbFunction extends Domain {
    private Integer id;
    private String name; //功能名称
    private Integer funCode;//功能编码
    private Integer pid;//关联上管理的功能id

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

    public Integer getFunCode() {
        return funCode;
    }

    public void setFunCode(Integer funCode) {
        this.funCode = funCode;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "TbFunction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", funCode='" + funCode + '\'' +
                ", pid=" + pid +
                '}';
    }
}