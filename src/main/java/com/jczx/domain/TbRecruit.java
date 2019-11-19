package com.jczx.domain;


import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 招生信息表
 * @author 于振华
 * @describe
 * @create 2019-11-18 16:27
 *
 */
@Component
public class TbRecruit extends Domain {
    private Integer id;
    private Integer labelId;//意向标签
    private Integer recruitDetailID;//招生详情表id
    private Integer channelId;//渠道表id
    private String name;//招生姓名
    private Boolean sex;//招生的性别
    private String intention;//招生意向
    private String birthDate;//出生年月
    private String school;//学校
    private String stuPhone;//学生电话
    private String qq;//qq号
    private String weChat;//微信
    private String parPhone;//家长电话;
    private String createTime;//创建时间
    private Integer operatorId;//操作人

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getRecruitDetailID() {
        return recruitDetailID;
    }

    public void setRecruitDetailID(Integer recruitDetailID) {
        this.recruitDetailID = recruitDetailID;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getParPhone() {
        return parPhone;
    }

    public void setParPhone(String parPhone) {
        this.parPhone = parPhone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
