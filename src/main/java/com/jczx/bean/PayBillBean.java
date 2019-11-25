package com.jczx.bean;
import java.util.Date;
/**
 * @author 丛枭钰
 * @create 2019-11-25 9:01
 */
public class PayBillBean {
    private Integer id;//缴费id
    private Integer studentId;//学号
    private String name;//学生姓名
    private String semester;//学年
    private String type;//缴费类型
    private String paymentMethod;//缴费方式
    private Integer totalAmount;//总金额
    private Boolean hasInstalment;//是否分期
    private Date payDate;//缴费时间
    private Integer discountAmount;//优惠金额
    private Integer payAmount;//金额
    private Integer factAmount;//总计
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private String invoice;//发票地址
    private String remark;//备注
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
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getHasInstalment() {
        return hasInstalment;
    }

    public void setHasInstalment(Boolean hasInstalment) {
        this.hasInstalment = hasInstalment;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
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

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
