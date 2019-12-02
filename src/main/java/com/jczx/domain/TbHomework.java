package com.jczx.domain;

import com.jczx.system.CACHE;
import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发布作业表
 *
 * @author 丛枭钰
 * @create 2019-11-19 13:25
 */
@Component
public class TbHomework extends Domain {
    private Integer id;
    private String name;//作业名称
    private Integer teacherId;//发布人
    private Integer majorId;//班级专业
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;//截止日期
    @FieldType(type = Type.VARCHAR, length = 255)
    private String content;//内容//长度问题
    private Boolean hasAttachment;//是否有附件
    private Integer submitCount;//提交人数
    @FieldType(type = Type.VARCHAR, length = 255)
    private String submitIds;//已提交人
    @FieldType(type = Type.VARCHAR, length = 255)
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
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

    public String getMajorName() {

        return CACHE.getMajorName(majorId);
    }
    public String getTeacherName() {

        return CACHE.getTeacherName(teacherId);
    }
}
