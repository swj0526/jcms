package com.jczx.domain;

import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 于振华
 * @describe 字典表
 * @create 2019-11-18 23:32
 */
@Component
public class TbDictionary extends Domain {
    //意向标签
    @NotCreate
    private static final Integer TYPE_LABEL = 1;
    //渠道
    @NotCreate
    private static final Integer TYPE_CHANNEL = 2;
    //缴费类型
    @NotCreate
    private static final Integer TYPE_PAYBILL = 3;
    //支付类型
    @NotCreate
    private static final Integer TYPE_PAY = 4;
    //学年,学期
    @NotCreate
    private static final Integer TYPE_TERM = 5;

    private Integer id;//字典表 就 id  和name和备注,类型type
    private String name;
    private String remark;//备注
    private String type;
    private Date createTime;//创建时间
    private Integer operatorId;//操作人

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
