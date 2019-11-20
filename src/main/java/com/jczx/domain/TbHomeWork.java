package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发布作业表
 * @author 丛枭钰
 * @create 2019-11-19 13:25
 *
 */
@Component
public class TbHomeWork extends Domain {
    private Integer id;
    private String name;//作业名称
    private String teacherId;//发布人
    private Integer classId;//年级
    private Date endTime;//截止日期
    private String content;//内容
    private Boolean enclosure;//是否有附件
    private Integer submitTheNumber;//提交人数
    private Integer headcount;//总人数
    private Integer operatorId;//操作人id
    private Date createTime;//创建时间

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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Boolean enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getSubmitTheNumber() {
        return submitTheNumber;
    }

    public void setSubmitTheNumber(Integer submitTheNumber) {
        this.submitTheNumber = submitTheNumber;
    }

    public Integer getHeadcount() {
        return headcount;
    }

    public void setHeadcount(Integer headcount) {
        this.headcount = headcount;
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
