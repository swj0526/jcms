package com.jczx.domain;

import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description 日志表
 * @author 孙文举
 * @create 2019-11-18 16:25
 */
@Component
public class TbLog  extends Domain {
    /**
     * 添加
     */
    @NotCreate
    public static final int TYPE_ADD=1;
    /**
     * 删除
     */
    @NotCreate
    public static final int TYPE_DEL=2;
    /**
     * 删除
     */
    @NotCreate
    public static final int TYPE_MOD=3;
    private Integer id;
    private Integer type;//操作类型 1.增加 2.删除 3.修改
    private String content; //操作内容
    private Integer operatorId;//操作人
    private Date createTime;//操作时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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