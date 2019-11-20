package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 发布文章
 * @author 宋家新
 * @create 2019-11-18 21:11
 */
@Component
public class TbArticle  extends Domain {
    private Integer id;
    private String title;//标题
    private String receiverRolIds;//接收人
    private String content;//内容
    private byte createTime;//发布时间
    private String read;//已读
    private String total;//应读
    private boolean enclosure;//是否有上传文件
    private Integer operatorId;//操作人
    private Integer type;//类型
    private static final Integer TYPE_ARTICLE=1;//类型常量

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

    public String getReceiverRolIds() {
        return receiverRolIds;
    }

    public void setReceiverRolIds(String receiverRolIds) {
        this.receiverRolIds = receiverRolIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte getCreateTime() {
        return createTime;
    }

    public void setCreateTime(byte createTime) {
        this.createTime = createTime;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public boolean isEnclosure() {
        return enclosure;
    }

    public void setEnclosure(boolean enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static Integer getTypeArticle() {
        return TYPE_ARTICLE;
    }
}
