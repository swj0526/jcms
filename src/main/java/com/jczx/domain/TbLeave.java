package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 请假流程
 * @author 宋家新
 * @create 2019-11-18 21:09
 */
@Component
public class TbLeave  extends Domain {
    private Integer id;
    private Integer studentId;//学生姓名
    private byte leaveTime; //请假时间
    private byte endTime;//结束时间
    private byte createTime;//申请时间
    private String content;//请假事由
    private Double days;//请假天数
    private Integer firstTeacherId;//一审老师
    private String firstReason;//一审是否通过
    private String firstContent;//一审意见
    private Integer secondTeacherId;//二审老师
    private String secondContent;//二审意见
    private String secondReason;//二审是否通过

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

    public byte getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(byte leaveTime) {
        this.leaveTime = leaveTime;
    }

    public byte getEndTime() {
        return endTime;
    }

    public void setEndTime(byte endTime) {
        this.endTime = endTime;
    }

    public byte getCreateTime() {
        return createTime;
    }

    public void setCreateTime(byte createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getDays() {
        return days;
    }

    public void setDays(Double days) {
        this.days = days;
    }

    public Integer getFirstTeacherId() {
        return firstTeacherId;
    }

    public void setFirstTeacherId(Integer firstTeacherId) {
        this.firstTeacherId = firstTeacherId;
    }

    public String getFirstReason() {
        return firstReason;
    }

    public void setFirstReason(String firstReason) {
        this.firstReason = firstReason;
    }

    public String getFirstContent() {
        return firstContent;
    }

    public void setFirstContent(String firstContent) {
        this.firstContent = firstContent;
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

    public String getSecondReason() {
        return secondReason;
    }

    public void setSecondReason(String secondReason) {
        this.secondReason = secondReason;
    }
}
