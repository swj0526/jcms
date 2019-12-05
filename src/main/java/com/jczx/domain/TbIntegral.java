package com.jczx.domain;

import com.jczx.system.CACHE;
import net.atomarrow.db.annotation.NotCreate;
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
    private Integer studentId;// 学生id
    private Integer totalScore;//总分
    private Integer operatorId;//操作人
    private Date createTime;//操作时间

    public String getStudentName() {
        return CACHE.getSemesterName(studentId);//获取学生姓名
    }
    public String getMajorName() {
        return CACHE.getMajorName(studentId);//学生id
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

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
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