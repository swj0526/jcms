package com.jczx.domain;

import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 学生表
 * @author cjw
 * @create 2019-11-17 12:52
 *
 */
@Component
public class TbStudent extends Domain {
    @NotCreate
    public static final int STATE_noEntrance=0;//未入学
    @NotCreate
    public static final int STATE_entrance=1;//入学

    private Integer id;
    private String name;//姓名
    private Integer gender;//性别
    private Integer age;//年龄
    private String address;//家庭住址
    private String nativePlace;//籍贯
    private String contact;//联系方式
    private String bloodType;//血型
    private Date createTime;//操作时间
    private Date graduationDate;//毕业时间
    private Integer state;//状态,区分已入学和未入学
    private String theClass;//班级//
    private Integer operatorId;//操作人
    private String motherPhone;//母亲联系方式
    private String fatherPhone;//父亲联系方式
    private String emergencyPhone;//应急联系方式
    //private Integer labelIds;//意向标签表
    private Integer channelId;//渠道表id
    private String intention;//招生意向
    private Date birthDate;//出生年月
    private String card;//身份证

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    private String school;//学校
    private String stuPhone;//学生电话
    private String qq;//qq号
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTheClass() {
        return theClass;
    }

    public void setTheClass(String theClass) {
        this.theClass = theClass;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    private String weChat;//微信
    private String parPhone;//家长电话;

}
