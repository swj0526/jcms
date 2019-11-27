package com.jczx.domain;

import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
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
    @NotCreate
    private  String paymentMethod;
    @NotCreate
    private String name;//学生姓名
    @NotCreate
    private String semester;//学期
    @NotCreate
    private String name1;//类型
    @NotCreate
    private String URL;//附件地址
    private Integer id;
    private Integer pid;//关联上次交费数据id
    private Integer studentId;//学生id
    private Integer typeId;//缴费类型
    private Integer paymentMethodId;//缴费方式
    private Integer semesterId;//学期
    private Integer totalAmount;//应付金额
    private Integer payAmount;//金额
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date payDate;//缴费日期//
    private Boolean hasInstalment;//是否分期
    private Integer discountAmount;//优惠金额
    private Integer factAmount;//实付金额//
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date startTime;//开始时间
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date endTime;//结束时间//end
    private Boolean hasAttachment;//是否有附件
    private Integer operatorId;//操作人id
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date createTime;//操作时间
    private String remark;//备注
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getType() {
        return name1;
    }

    public void setType(String type) {
        this.name1 = type;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

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

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
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

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
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



  /*  *//**
     * 缴费类型
     * @return
     *//*
    public String getTypeName(){
        return CACHE.getTypeName(typeId);
    }

    *//**
     * 缴费方式
     * @return
     *//*
    public String getPaymentMethodName(){

        return CACHE.getPaymentMethodName(paymentMethodId);
    }

    *//**
     * 学年
     * @return
     *//*
    public String getSemesterName(){

        return CACHE.getSemesterName(semesterId);
    }*/
}
