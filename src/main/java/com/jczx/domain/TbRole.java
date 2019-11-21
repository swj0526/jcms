package com.jczx.domain;

import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description 角色类
 * @author 孙文举
 * @create 2019-11-18 16:11
 */
@Component
public class TbRole extends Domain {
    private Integer id;
    private String name;//角色名称
    private String remark;//角色备注
    @FieldType(type = Type.VARCHAR,length = 200)
    private String functionIds;//权限列表
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFunctionIds() {
        return functionIds;
    }

    public void setFunctionIds(String functionIds) {
        this.functionIds = functionIds;
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