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
    private String receiver;//接收人
    private String type;//类型
    private String publisher;//发布人
    private String content;//内容
    private String createTime;//发布时间
    private String number;//查看人数
    private boolean fileUrl;//是否有上传文件
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(boolean fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
