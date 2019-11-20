package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 学生作业上传表
 * @author 丛枭钰
 * @create 2019-11-19 13:58
 *
 */
@Component
public class TbStudentWork extends Domain {
    private Integer id;
    private Integer studentId;//学生表id
    private Integer workId;//作业id//homeworkId
    private Boolean hasEnclosure;//是否有附件//
    //缺俩content考虑长度,那个老师打得分,attachment附件
    private Integer score;//分数
    private Integer operatorId;//操作人id
    private Date createTime;//操作时间

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

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Boolean getHasEnclosure() {
        return hasEnclosure;
    }

    public void setHasEnclosure(Boolean hasEnclosure) {
        this.hasEnclosure = hasEnclosure;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
