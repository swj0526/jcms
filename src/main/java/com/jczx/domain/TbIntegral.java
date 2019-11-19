package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author cjw
 * @create 2019-11-17 12:57
 * 积分表
 */
@Component
public class TbIntegral extends Domain {
    private Integer id;
    private String name;
    private String time;//时间
    private String reason;//事由
    private Integer score;//分数，加了多少分，减了多少分
    private Integer operatorId;//操作人
    private String bonusPoints;//加分项
    private String reductionOf;//减分项
    private String createTime;//操作时间

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    private Integer totalScore;//总分
}
