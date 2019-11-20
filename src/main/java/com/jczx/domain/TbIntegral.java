package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 积分表
 * @author cjw
 * @create 2019-11-17 12:57
 *
 */
@Component
public class TbIntegral extends Domain {
    private Integer id;
    private String name;
    private String recordTime;//时间
    private String reason;//事由
    private Integer score;//分数，加了多少分，减了多少分
    private Integer operatorId;//操作人
    private String bonusPoints;//加分项
    private String reductionOf;//减分项
    private String createTime;//操作时间

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

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(String bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public String getReductionOf() {
        return reductionOf;
    }

    public void setReductionOf(String reductionOf) {
        this.reductionOf = reductionOf;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}