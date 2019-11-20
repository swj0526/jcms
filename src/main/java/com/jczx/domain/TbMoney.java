package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 缴费表
 * @author 丛枭钰
 * @create 2019-11-19 13:14
 *
 */
@Component
public class TbMoney extends Domain {
    private Integer id;
    private Integer studentId;//学生id
    private Integer paymentTypeId;//缴费类型
    private Integer method;//缴费方式
    private Integer totalMoney;//总金额
    private Integer money;//金额
    private String paymentDate;//缴费日期
    private Boolean instalment;//是否分期
    private Integer discount;//优惠金额
    private Integer aggregate;//总计
    private Integer startTime;//开始时间
    private String validity;//费用有效期
    private Integer operatorId;//操作人id
    private String createTime;//操作时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Boolean getInstalment() {
        return instalment;
    }

    public void setInstalment(Boolean instalment) {
        this.instalment = instalment;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getAggregate() {
        return aggregate;
    }

    public void setAggregate(Integer aggregate) {
        this.aggregate = aggregate;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
