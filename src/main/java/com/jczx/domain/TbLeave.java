package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 请假流程
 *
 * @author 宋家新
 * @create 2019-11-18 21:09
 */
@Component
public class TbLeave extends Domain {

    private Integer id;
    private Integer studentId;//学生姓名
    private Date leaveTime; //请假时间
    private Date endTime;//结束时间
    private Date createTime;//申请时间
    private String content;//请假事由
    private Double dayCount;//请假天数
    private Integer firstTeacherId;//一审老师
    private Boolean firstState;//一审是否通过
    private String firstContent;//一审意见
    private Date firstOperatorTime;//一审操作时间
    private Integer secondTeacherId;//二审老师
    private String secondContent;//二审意见
    private Boolean secondState;//二审是否通过
    private Date secondOperatorTime;//二审操作时间
    private Integer operatorId;//操作人//必有,学生id

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

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getDayCount() {
        return dayCount;
    }

    public void setDayCount(Double dayCount) {
        this.dayCount = dayCount;
    }

    public Integer getFirstTeacherId() {
        return firstTeacherId;
    }

    public void setFirstTeacherId(Integer firstTeacherId) {
        this.firstTeacherId = firstTeacherId;
    }

    public Boolean getFirstState() {
        return firstState;
    }

    public void setFirstState(Boolean firstState) {
        this.firstState = firstState;
    }

    public String getFirstContent() {
        return firstContent;
    }

    public void setFirstContent(String firstContent) {
        this.firstContent = firstContent;
    }

    public Date getFirstOperatorTime() {
        return firstOperatorTime;
    }

    public void setFirstOperatorTime(Date firstOperatorTime) {
        this.firstOperatorTime = firstOperatorTime;
    }

    public Integer getSecondTeacherId() {
        return secondTeacherId;
    }

    public void setSecondTeacherId(Integer secondTeacherId) {
        this.secondTeacherId = secondTeacherId;
    }

    public String getSecondContent() {
        return secondContent;
    }

    public void setSecondContent(String secondContent) {
        this.secondContent = secondContent;
    }

    public Boolean getSecondState() {
        return secondState;
    }

    public void setSecondState(Boolean secondState) {
        this.secondState = secondState;
    }

    public Date getSecondOperatorTime() {
        return secondOperatorTime;
    }

    public void setSecondOperatorTime(Date secondOperatorTime) {
        this.secondOperatorTime = secondOperatorTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
