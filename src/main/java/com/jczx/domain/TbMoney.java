package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 缴费表
 *
 * @author 丛枭钰
 * @create 2019-11-19 13:14
 */
@Component
public class TbMoney extends Domain {
    private Integer id;
    private Integer studentId;//学生id
    private Integer dictionariesId;//缴费类型
    private Integer totalAmount;//总金额
    private Integer payableAccount;//金额
    private Date paymentDate;//缴费日期
    private Boolean instalment;//是否分期
    private Integer discountAmount;//优惠金额
    private Integer paidAmount;//总计
    private Date startTime;//开始时间
    private Date entTime;//结束时间
    private Integer operatorId;//操作人id
    private Date createTime;//操作时间

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

    public Integer getDictionariesId() {
        return dictionariesId;
    }

    public void setDictionariesId(Integer dictionariesId) {
        this.dictionariesId = dictionariesId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayableAccount() {
        return payableAccount;
    }

    public void setPayableAccount(Integer payableAccount) {
        this.payableAccount = payableAccount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Boolean getInstalment() {
        return instalment;
    }

    public void setInstalment(Boolean instalment) {
        this.instalment = instalment;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEntTime() {
        return entTime;
    }

    public void setEntTime(Date entTime) {
        this.entTime = entTime;
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
