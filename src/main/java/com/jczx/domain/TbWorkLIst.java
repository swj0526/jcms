package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 丛枭钰
 * @create 2019-11-19 13:25
 * 发布作业表
 */
@Component
public class TbWorkLIst extends Domain {
    private Integer id;
    private String name;//作业名称
    private String issuer;//发布人
    private Integer grade;//年级
    private String releaseTime;//发布日期
    private String deadline;//截止日期
    private String content;//内容
    private Integer submitTheNumber;//提交人数
    private Integer operatorId;//操作人id
    private String createTime;//操作时间
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSubmitTheNumber() {
        return submitTheNumber;
    }

    public void setSubmitTheNumber(Integer submitTheNumber) {
        this.submitTheNumber = submitTheNumber;
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
