package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发布作业表
 * @author 丛枭钰
 * @create 2019-11-19 13:25
 *
 */
@Component
public class TbHomework extends Domain {
    private Integer id;
    private String name;//作业名称
    private String majorId;//发布人
    private Integer classId;//年级
    private Date endTime;//截止日期
    private String content;//内容//长度问题
    private Boolean hasAttachment;//是否有附件
    private Integer submitCount;//提交人数
    private String submitIds;//提交人
    private String notSubmitIds;//未提交人
    private Integer totalCount;//总人数
    private Integer operatorId;//操作人id
    private Date createTime;//创建时间

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

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public Integer getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(Integer submitCount) {
        this.submitCount = submitCount;
    }

    public String getSubmitIds() {
        return submitIds;
    }

    public void setSubmitIds(String submitIds) {
        this.submitIds = submitIds;
    }

    public String getNotSubmitIds() {
        return notSubmitIds;
    }

    public void setNotSubmitIds(String notSubmitIds) {
        this.notSubmitIds = notSubmitIds;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
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
