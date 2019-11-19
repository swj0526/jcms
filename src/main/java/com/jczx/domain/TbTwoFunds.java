package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 宋家新
 * @create 2019-11-19 14:59
 */
@Component
public class TbTwoFunds extends Domain {
    private Integer id;
    private Integer fundsId;//经费申请Id
    private String twoTrial;//二审老师
    private String twoAdopt;//二审是否通过
    private String twoReason;//二审意见

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFundsId() {
        return fundsId;
    }

    public void setFundsId(Integer fundsId) {
        this.fundsId = fundsId;
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
