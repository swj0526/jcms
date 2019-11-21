package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 事由表
 * @author 池炯武
 * @create 2019-11-20 19:30
 */
@Component
public class TbIntegralItem extends Domain {
    private  Integer id;
    private Integer score;//记录加分减分
private String reason;//事由

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
