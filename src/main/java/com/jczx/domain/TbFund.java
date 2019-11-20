package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 经费流程
 * @author 宋家新
 * @create 2019-11-18 21:09
 */
@Component
public class TbFund extends Domain {
    private Integer id;
    private Integer studentId;//学生姓名
    private String content;//申请事由
    private String activityAmount;//申请金额
    private byte createTime;//申请日期
    private byte startDate;//开始日期
    private Integer firstTeacherId;//一审老师
    private boolean firstReason;//一审是否通过
    private String firstContent;//一审意见
    private Integer secondTeacherId;//二审老师
    private boolean secondReason;//二审是否通过
    private String secondContent;//二审意见

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

    public byte getCreateTime() {
        return createTime;
    }

    public void setCreateTime(byte createTime) {
        this.createTime = createTime;
    }

    public byte getStartDate() {
        return startDate;
    }

    public void setStartDate(byte startDate) {
        this.startDate = startDate;
    }

    public Integer getFirstTeacherId() {
        return firstTeacherId;
    }

    public void setFirstTeacherId(Integer firstTeacherId) {
        this.firstTeacherId = firstTeacherId;
    }

    public boolean isFirstReason() {
        return firstReason;
    }

    public void setFirstReason(boolean firstReason) {
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

    public boolean isSecondReason() {
        return secondReason;
    }

    public void setSecondReason(boolean secondReason) {
        this.secondReason = secondReason;
    }

    public String getSecondContent() {
        return secondContent;
    }

    public void setSecondContent(String secondContent) {
        this.secondContent = secondContent;
    }
}
