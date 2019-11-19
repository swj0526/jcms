package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 请假一审
 * @author 宋家新
 * @create 2019-11-19 14:54
 */
@Component
public class TbOneLeave extends Domain {
    private Integer id;
    private Integer leaveId;//请假申请Id
    private String ontTrial;//一审老师
    private String oneReason;//一审是否通过
    private String oneAdopt;//一审意见

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

    public String getOntTrial() {
        return ontTrial;
    }

    public void setOntTrial(String ontTrial) {
        this.ontTrial = ontTrial;
    }

    public String getOneReason() {
        return oneReason;
    }

    public void setOneReason(String oneReason) {
        this.oneReason = oneReason;
    }

    public String getOneAdopt() {
        return oneAdopt;
    }

    public void setOneAdopt(String oneAdopt) {
        this.oneAdopt = oneAdopt;
    }
}
