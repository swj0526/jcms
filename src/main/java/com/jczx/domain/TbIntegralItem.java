package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 事由表
 *
 * @author 池炯武
 * @create 2019-11-20 19:30
 */
@Component
public class TbIntegralItem extends Domain {
    /**
     * 加分
     */
    private static final int TYPE_ADD=0;
    /**
     * 减分
     */
    private static final int TYPE_SUBTRACT=0;
    private Integer id;
    private Integer score;//记录加分减分
    private String reason;//事由
    private Integer type;//判断加分减分

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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
