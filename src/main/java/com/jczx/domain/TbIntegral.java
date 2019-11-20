package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 积分表
 * @author cjw
 * @create 2019-11-17 12:57
 *
 */
@Component
public class TbIntegral extends Domain {
    private Integer id;
    private String recordTime;//时间
    private Integer operatorId;//操作人
    private String createTime;//操作时间
    private Integer studentId;// 学生id
    private Integer totalScore;//总分

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}