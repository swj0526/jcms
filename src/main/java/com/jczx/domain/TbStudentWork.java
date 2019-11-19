package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 丛枭钰
 * @create 2019-11-19 13:58
 * 学生作业上传表
 */
@Component
public class TbStudentWork extends Domain {
    private Integer id;
    private Integer studentId;//学生表id
    private Integer workListId;//作业列表id
    private String fileUrl;//作业文件地址
    private Integer score;//分数
    private Integer operatorId;//操作人id
    private String createTime;//操作时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTbStudentId() {
        return studentId;
    }

    public void setTbStudentId(Integer tbStudentId) {
        studentId = tbStudentId;
    }

    public Integer getTbWorkListId() {
        return workListId;
    }

    public void setTbWorkListId(Integer tbWorkListId) {
        workListId = tbWorkListId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
