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
public class TbPayBill extends Domain {
    private Integer id;
    private Integer pid;//关联上次交费数据id
    private Integer studentId;//学生id
    private Integer typeId;//缴费类型tbDictionary
    private Integer totalAmount;//应付金额
    private Integer payAmount;//金额
    private Date payDate;//缴费日期
    private Boolean hasInstalment;//是否分期
    private Integer discountAmount;//优惠金额
    private Integer factAmount;//实付金额
    private Date startTime;//开始时间
    private Date endTime;//结束时间//end
    private Integer operatorId;//操作人id
    private Date createTime;//操作时间
    private String remark;//备注
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Boolean getHasInstalment() {
        return hasInstalment;
    }

    public void setHasInstalment(Boolean hasInstalment) {
        this.hasInstalment = hasInstalment;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getFactAmount() {
        return factAmount;
    }

    public void setFactAmount(Integer factAmount) {
        this.factAmount = factAmount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
