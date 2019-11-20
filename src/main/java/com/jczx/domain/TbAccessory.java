package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 附件表
 * @author 丛枭钰
 * @create 2019-11-20 14:00
 */
@Component
public class TbAccessory extends Domain {
    private Integer id;
    private String URl;
    private Integer operatorId;//操作人id
    private Date createTime;//创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getURl() {
        return URl;
    }

    public void setURl(String URl) {
        this.URl = URl;
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
