package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 二审
 * @author 宋家新
 * @create 2019-11-19 14:55
 */
@Component
public class TbTwoLeave extends Domain {
    private Integer id;
    private Integer leaveId;//请假申请Id
    private String twoTrial;//二审老师
    private String twoAdopt;//二审是否通过
    private String twoReason;//二审意见

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public String getTwoTrial() {
        return twoTrial;
    }

    public void setTwoTrial(String twoTrial) {
        this.twoTrial = twoTrial;
    }

    public String getTwoAdopt() {
        return twoAdopt;
    }

    public void setTwoAdopt(String twoAdopt) {
        this.twoAdopt = twoAdopt;
    }

    public String getTwoReason() {
        return twoReason;
    }

    public void setTwoReason(String twoReason) {
        this.twoReason = twoReason;
    }
}
