package com.jczx.domain;

import com.jczx.system.CACHE;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 学生表
 *
 * @author 池炯武
 * @create 2019-11-17 12:52
 */
@Component
public class TbStudent extends Domain {
    //缺积分,状态性别
    @NotCreate
    public static final int STATE_NOT_ENTRANCE = 0;//未入学
    @NotCreate
    public static final int STATE_ENTRANCE = 1;//入学
    @NotCreate
    public static final int STATE_GRADUATE = 3;//毕业
    private Integer id;
    private Integer majorId;//班级id
    private String name;//姓名
    private String sex;//性别
    private Integer age;//年龄
    private String nation;//民族
    private String address;//家庭住址
    private String nativePlace;//籍贯
    private String bloodType;//血型
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admissionData;//入学时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date graduationDate;//毕业时间
    private Integer state;//状态,区分已入学和未入学
    private String motherName;//母亲名字
    private String fatherName;//父亲名字
    private String otherRelativesName;//其他亲属名字
    private String motherPhone;//母亲联系方式
    private String fatherPhone;//父亲联系方式
    private String emergencyPhone;//其他亲属联系方式
    private String labelIds;//意向标签表
    private Integer channelId;//渠道表id
    private String intention;//招生意向
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;//出生年月
    private String IDCard;//身份证//
    private String school;//学校
    private String studentPhone;//学生电话//
    private String qq;//qq号
    private String weChat;//微信
    private Integer integralId;//积分
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//操作时间
    private Integer operatorId;//操作人

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getOtherRelativesName() {
        return otherRelativesName;
    }

    public void setOtherRelativesName(String otherRelativesName) {
        this.otherRelativesName = otherRelativesName;
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

    public String getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
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

    public Date getAdmissionData() {
        return admissionData;
    }

    public void setAdmissionData(Date admissionData) {
        this.admissionData = admissionData;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
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

    public Integer getIntegralId() {
        return integralId;
    }

    public void setIntegralId(Integer integralId) {
        this.integralId = integralId;
    }

    public String getChannelName() {

        return CACHE.getChannelName(channelId);
    }

    /**
     * 意向标签
     *
     * @return
     */
    public String getLabelNames() {
        return CACHE.getLabelNames(labelIds);
    }
    /**
     * 状态
     */
    public String getStateName(){
        if (this.state==STATE_ENTRANCE){
            return "在校";
        }
        return"未入学";
    }
}
