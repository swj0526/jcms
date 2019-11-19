package com.jczx.domain;

/**
 * @author 37346
 * @create 2019-11-19 13:14
 */
public class TbMoney {
    Integer id;
    Integer studentId;//学生id
    String theClassId;//班级id
    Integer type;//缴费类型
    Integer method;//缴费方式
    Integer money;//金额
    String paymentDate;//缴费日期
    Boolean instalment;//是否分期
    Integer discount;//优惠金额
    String Validity;//费用有效期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
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

    public String getValidity() {
        return Validity;
    }

    public void setValidity(String validity) {
        Validity = validity;
    }
}
