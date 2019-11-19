package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 宋家新
 * @create 2019-11-19 14:58
 */
@Component
public class TbOneFunds extends Domain {
    private Integer id;
    private Integer fundsId;//经费申请Id
    private String ontTrial;//一审老师
    private String oneReason;//一审是否通过
    private String oneAdopt;//一审意见

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
