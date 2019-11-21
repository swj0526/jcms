package com.jczx.domain;

import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发布文章
 * @author 宋家新
 * @create 2019-11-18 21:11
 */
@Component
public class TbArticle  extends Domain {
    private Integer id;
    private String title;//标题
    private String receiverRoleIds;//接收人,长度40够用
    private String content;//内容
    private Integer readCount;//已读数//count
    private Integer totalCount;//应读数//count
    @FieldType(type = Type.VARCHAR,length = 200)
    private String readIds;//已读
    private String totalIds;//应读
    private Boolean hasAttachment;//是否有上传文件//单词
    private Integer operatorId;//操作人
    private Date createTime;//发布时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReceiverRoleIds() {
        return receiverRoleIds;
    }

    public void setReceiverRoleIds(String receiverRoleIds) {
        this.receiverRoleIds = receiverRoleIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getReadIds() {
        return readIds;
    }

    public void setReadIds(String readIds) {
        this.readIds = readIds;
    }

    public String getTotalIds() {
        return totalIds;
    }

    public void setTotalIds(String totalIds) {
        this.totalIds = totalIds;
    }

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
