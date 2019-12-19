package com.jczx.bean;

import java.util.Date;

/**
 * @author 于振华
 * @create 2019-12-15 20:22
 */
public class RemindBean {
    private String name;//学生姓名
    private String majorName;//专业姓名
    private Date payDate;//上次缴费日期
    private Integer factAmount;//上次实付金额
    private Date startTime;//开始时间
    private Date endTime;//结束时间



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Integer getFactAmount() {
        return factAmount;
    }

    public void setFactAmount(Integer factAmount) {
        this.factAmount = factAmount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "RemindBean{" +
                "name='" + name + '\'' +
                ", majorName='" + majorName + '\'' +
                ", payDate=" + payDate +
                ", factAmount=" + factAmount +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
