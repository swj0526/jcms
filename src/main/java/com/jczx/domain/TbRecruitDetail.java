package com.jczx.domain;

import com.jczx.system.CACHE;
import com.jczx.system.OptionInterface;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date followTime;//跟进时间
    private Integer followCount;//第几次跟进
    private String labelIds;//跟进意向(标签)tbDictionary
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
    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public String getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
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
    /**
     * 意向标签
     *
     * @return
     */
    public String listLabelName(){
        return CACHE.getLabelNames(labelIds);
    }


}
