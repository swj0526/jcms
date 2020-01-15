package com.jczx.domain;

import com.jczx.system.CACHE;
import com.jczx.system.OptionInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbStudent extends Domain implements OptionInterface {
    @NotCreate
    public static final int STATE_AT_SCHOOL = 1;//在学
    @NotCreate
    public static final String STATE_AT_SCHOOL_NAME = "在校";//在学
    @NotCreate
    public static final int STATE_GRADUATE = 2;//毕业
    @NotCreate
    public static final String STATE_GRADUATE_NAME = "毕业";//毕业
    @NotCreate
    public static final int STATE_ENTRANCE = 3;//入学已缴费
    @NotCreate
    public static final int STATE_NOT_ENTRANCE = 4;//未入学未交费

    private Integer id;
    private Integer majorId;//班级id
    private Integer studentNumber;//学号
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
    private Integer schoolState;//学生在校状态
    private Integer entranceState;//状态,区分已入学和未入学
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
    private String hobby;//业余爱好
    private String speciality;//特长
    private String comment;//老师评论
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//操作时间
    private Integer operatorId;//操作人

    /**
     * 渠道名
     * @return
     */
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
    public String getStateName() {
        if (schoolState == null) {
            return "";
        }
        if (schoolState == STATE_AT_SCHOOL) {
            return STATE_AT_SCHOOL_NAME;
        }
        return STATE_GRADUATE_NAME;
    }



    /**
     * 获取专业班级名称
     *
     * @return
     */
    public String getMajorName() {
        return CACHE.getMajorName(majorId);
    }

    @Override
    public String getOptionText() {
        return name + "(" + studentNumber + ")";
    }

    @Override
    public String getOptionValue() {
        return id + "";
    }

}
