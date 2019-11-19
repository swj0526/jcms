package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 渠道表
 * @author 于振华
 * @describe
 * @create 2019-11-18 23:32
 *
 */
@Component
public class TbChannel extends Domain {
    private Integer id;
    private String name;//来源渠道名
    private String createTime;//创建时间
    private Integer operatorId;//操作人


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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }


}
