package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 经费流程
 * @author 宋家新
 * @create 2019-11-18 21:09
 */
@Component
public class TbFund extends Domain {
    private Integer id;
    private Integer studentId;//学生id
    private String content;//申请事由
    private String activityAmount;//申请金额
    private Date startDate;//开始日期
    private Integer firstTeacherId;//一审老师
    private Boolean firstReason;//一审是否通过
    private String firstContent;//一审意见
    private Date firstCreateTime;//一审操作时间
    private Integer secondTeacherId;//二审老师
    private Boolean secondReason;//二审是否通过
    private String secondContent;//二审意见
    private Date secondCreateTime;//二审操作时间
    //private Integer operatorId;//操作人


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getActivityAmount() {
        return activityAmount;
    }

    public void setActivityAmount(String activityAmount) {
        this.activityAmount = activityAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getFirstTeacherId() {
        return firstTeacherId;
    }

    public void setFirstTeacherId(Integer firstTeacherId) {
        this.firstTeacherId = firstTeacherId;
    }

    public Boolean getFirstReason() {
        return firstReason;
    }

    public void setFirstReason(Boolean firstReason) {
        this.firstReason = firstReason;
    }

    public String getFirstContent() {
        return firstContent;
    }

    public void setFirstContent(String firstContent) {
        this.firstContent = firstContent;
    }

    public Date getFirstCreateTime() {
        return firstCreateTime;
    }

    public void setFirstCreateTime(Date firstCreateTime) {
        this.firstCreateTime = firstCreateTime;
    }

    public Integer getSecondTeacherId() {
        return secondTeacherId;
    }

    public void setSecondTeacherId(Integer secondTeacherId) {
        this.secondTeacherId = secondTeacherId;
    }

    public Boolean getSecondReason() {
        return secondReason;
    }

    public void setSecondReason(Boolean secondReason) {
        this.secondReason = secondReason;
    }

    public String getSecondContent() {
        return secondContent;
    }

    public void setSecondContent(String secondContent) {
        this.secondContent = secondContent;
    }

    public Date getSecondCreateTime() {
        return secondCreateTime;
    }

    public void setSecondCreateTime(Date secondCreateTime) {
        this.secondCreateTime = secondCreateTime;
    }
}
