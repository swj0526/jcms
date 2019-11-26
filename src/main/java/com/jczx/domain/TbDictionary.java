package com.jczx.domain;

import com.jczx.system.CACHE;
import com.jczx.system.OptionInterface;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import net.atomarrow.util.SpringContextUtil;
import org.springframework.stereotype.Component;

import javax.swing.text.TabableView;
import java.util.Date;

/**
 * @author 于振华
 * @describe 字典表
 * @create 2019-11-18 23:32
 */
@Component
public class TbDictionary extends Domain implements OptionInterface {
    /**
     *  意向标签
     */
    @NotCreate
    public static final int TYPE_LABEL = 1;
    /**
     * 渠道
     */
    @NotCreate
     public static final int TYPE_CHANNEL = 2;
    /**
     * 缴费类型
     */
    @NotCreate
    public static final int TYPE_PAY_BILL = 3;
    /**
     * 缴费方式
     */
    @NotCreate
    public static final int TYPE_PAY = 4;
    /**
     * 学年,学期
     */
    @NotCreate
    public static final int TYPE_TERM = 5;
    /**
     * 发文类型
     */
    @NotCreate
    public static final int TYPE_DISPATCH = 6;

    private Integer id;
    private String name;
    private Integer type;//字典表类型
    private String remark;//备注
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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

    @Override
    public String getOptionText() {
        return name;
    }

    @Override
    public String getOptionValue() {
        return id+"";
    }



}
