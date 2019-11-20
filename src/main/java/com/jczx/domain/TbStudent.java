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
    //缺积分,状态性别
    @NotCreate
    public static final int STATE_NOT_ENTRANCE=0;//未入学
    @NotCreate
    public static final int STATE_ENTRANCE=1;//入学
    @NotCreate
    public static final int STATE_GRADUATE=3;//毕业
    private Integer id;
    private Integer majorId;//班级id
    private String name;//姓名
    private Integer sex;//性别//string
    private Integer age;//年龄
    private String address;//家庭住址
    private String nativePlace;//籍贯
    private String bloodType;//血型
    private Date createTime;//操作时间
    private Date graduationDate;//毕业时间
    private Integer state;//状态,区分已入学和未入学
    private Integer operatorId;//操作人
    //name
    private String motherPhone;//母亲联系方式
    private String fatherPhone;//父亲联系方式
    private String emergencyPhone;//应急联系方式
    private String labelIds;//意向标签表
    private Integer channelId;//渠道表id
    private String intention;//招生意向
    private Date birthDate;//出生年月
    private String card;//身份证//IDCard
    private String school;//学校
    private String studentPhone;//学生电话//student
    private String qq;//qq号
    private String weChat;//微信


}
