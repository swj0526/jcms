package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 学生积分列表
 * @author 池炯武
 * @create 2019-11-17 12:57
 *
 */
@Component
public class TbIntegral extends Domain {
    private Integer id;
    private Date recordTime;//事情发生时间
    private Integer operatorId;//操作人
    private Date createTime;//操作时间
    private Integer studentId;// 学生id
    private Integer totalScore;//总分
//缺加分减分字段,  规范表IntegralItem  加分规则字段
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}