package com.jczx.domain;

import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 附件表
 * @author 丛枭钰
 * @create 2019-11-20 14:00
 */

@Component
public class TbAttachment extends Domain {
    /**
     * 作业
     */
    @NotCreate
    public static final int TYPE_WORK=1;
    /**
     * 文章
     */
    @NotCreate
    public static final int TYPE_ARTICLE=2;

    private Integer id;
    private Integer type;//类型//定义type类型
    private Integer linkId;//链接
    @FieldType(type = Type.VARCHAR,length = 100)
    private String URL;//附件地址//长度
    private Integer operatorId;//操作人id
    @FieldType(type = Type.DATETIME)
    private Date createTime;//创建时间

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

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
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
