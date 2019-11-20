package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @describ 招生跟进详情表
 * @author 于振华
 *
 * @create 2019-11-19 20:26
 */
@Component
public class RecruitDetail  extends Domain {
    private Integer id;
   // private Integer channelId;//招生渠道表id;
    private String followTime;//跟进时间
    private String followState;//跟进状态
    private String createTime;//创建时间
    private Integer operatorId;//操作人
    private String remark;//备注

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
