package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**@describ 招生跟进详情表
 * @author 于振华
 * @create 2019-11-19 20:26
 */
@Component
public class TbRecruitDetail extends Domain {
    private Integer id;
    private Integer studentId;//学生(招生)表id;
    private Date followTime;//跟进时间
    private Integer followNumber;//第几次跟进
    private String followIds;//跟进状态(标签)
    private Date createTime;//创建时间
    private Integer operatorId;//操作人
    private String remark;//备注

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

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public Integer getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(Integer followNumber) {
        this.followNumber = followNumber;
    }

    public String getFollowIds() {
        return followIds;
    }

    public void setFollowIds(String followIds) {
        this.followIds = followIds;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
