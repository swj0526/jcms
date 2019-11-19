package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 于振华
 * @describe
 * @create 2019-11-18 23:32
 * 渠道表
 */
@Component
public class TbChannel extends Domain {
    private Integer id;
    private Integer RecruitId;//招生id
    private String name;//来源渠道名
    private String createTime;//创建时间
    private String followTime;//跟进时间
    private String followState;//跟进状态
    private String remark;//备注
    private Integer operatorId;//操作人

    public Integer getRecruitId() {
        return RecruitId;
    }

    public void setRecruitId(Integer recruitId) {
        RecruitId = recruitId;
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFollowTime() {
        return followTime;
    }

    public void setFollowTime(String followTime) {
        this.followTime = followTime;
    }

    public String getFollowState() {
        return followState;
    }

    public void setFollowState(String followState) {
        this.followState = followState;
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
}
