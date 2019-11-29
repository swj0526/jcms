package com.jczx.domain;

import com.jczx.system.OptionInterface;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 专业表
 * @author 孙文举
 * @create 2019-11-20 14:51
 */
@Component
public class TbMajor extends Domain implements OptionInterface {
    /**
     *
     */
    @NotCreate
    public static final int TYPE_MAJOR=0;
    /**
     *
     */
    @NotCreate
    public static final int TYPE_GRADE=1;
    private Integer id;
    private String name; //专业名称
    private Integer pid; //班级关联
    private Integer operatorId;//操作人
    private Date createTime;//操作时间
    private String remark;//备注
    //操作人,时间

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    @Override
    public String getOptionText() {
        return name;
    }

    @Override
    public String getOptionValue() {
        return id+"";
    }
}
