package com.jczx.domain;

import com.jczx.system.CACHE;
import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 丛枭钰
 * @create 2019-11-29 11:30
 */
@Component
public class TbIntegralHistory extends Domain {
    private Integer id;//id
    private Integer studentId;//学生id
    @FieldType(type = Type.DATETIME)
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date recordTime;//事发时间
    private String reason;//事由
    private Integer score;//分数
    private String remark;//备注
    private Integer operatorId;//操作人
    private Date createTime;//操作时间

    public String getName() {
        return CACHE.getStudentName(studentId);
    }
    public String getMajorName() {

        return CACHE.getMajorName(CACHE.getStudent(studentId).getMajorId());
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

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

