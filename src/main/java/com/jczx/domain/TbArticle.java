package com.jczx.domain;

import net.atomarrow.db.annotation.NotCreate;
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
    @NotCreate
    private static final int TYPE_ARTICLE=1;//类型常量不要   //换用字典表加type字段
    private Integer id;
    private String title;//标题
    private String receiverRoleIds;//接收人,长度40够用
    private String content;//内容
    private Date createTime;//发布时间
    private Integer read;//已读数//count
    private Integer total;//应读数//count
    private String readIds;//已读
    private String totalIds;//应读
    private Boolean hasEnclosure;//是否有上传文件//单词
    private Integer operatorId;//操作人



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

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public Boolean getHasEnclosure() {
        return hasEnclosure;
    }

    public void setHasEnclosure(Boolean hasEnclosure) {
        this.hasEnclosure = hasEnclosure;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
