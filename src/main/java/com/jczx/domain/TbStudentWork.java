package com.jczx.domain;

import com.jczx.service.AttachmentService;
import com.jczx.system.CACHE;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 学生作业上传表
 *
 * @author 丛枭钰
 * @create 2019-11-19 13:58
 */
@Component
public class TbStudentWork extends Domain {
    private Integer id;
    private Integer studentId;//学生表id
    private Integer homeworkId;//作业id//homeworkId
    private Boolean hasAttachment;//是否有附件//
    private String content;//内容
    private String estimateContent;//评价
    private Integer score;//分数
    private Integer teacherId;//评价老师
    private Integer operatorId;//操作人id
    private Date createTime;//操作时间
    private List<TbAttachment> list;

    public List<TbAttachment> getList() {
        return list;
    }

    public void setList(List<TbAttachment> list) {
        this.list = list;
    }

    public String getName() {
        return CACHE.getStudentName(studentId);
    }

    public String getMajor() {
        System.out.println(CACHE.getMajorName(studentId));
        return CACHE.getMajorName(studentId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEstimateContent() {
        return estimateContent;
    }

    public void setEstimateContent(String estimateContent) {
        this.estimateContent = estimateContent;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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
