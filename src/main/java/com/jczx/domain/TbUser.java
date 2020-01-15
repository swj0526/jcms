package com.jczx.domain;

import com.jczx.system.CACHE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 孙文举
 * @description 用户表, 用来登录跟盘算权限的
 * @create 2019-11-18 16:45
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUser extends Domain {
    /**
     * 学生
     */
    @NotCreate
    public static final int TYPE_STUDENT = 1;
    /**
     * 教职工
     */
    @NotCreate
    public static final int TYPE_TEACHER = 2;
    /**
     * 未激活
     */
    @NotCreate
    public static final boolean TYPE_NO_ENABLE = false;
    /**
     * 已激活
     */
    @NotCreate
    public static final boolean TYPE_ENABLE = true;
    private Integer id;
    private Integer type;//类型 1.学生 2.教职工
    private Integer accountId;//跟具体的信息表关联id
    private String phone;//手机号码,登录时的用户名
    private String name;//用户姓名
    private String password;//密码
    private String roleIds;//角色列表
    private Integer operatorId;//操作人
    @FieldType(type = Type.DATETIME)
    private Date createTime;//操作时间
    private Boolean enable;//该账号是否被激活//0.未激活,1.已激活



    /**
     * 获取学生姓名
     *
     * @return
     */
    public String getStudentName() {
        TbStudent student = CACHE.getStudent(accountId);
        if (student == null) {
            return "";
        }
        return student.getName() + "(" + student.getStudentNumber() + ")";
    }

    /**
     * 获取教师姓名
     *
     * @return
     */
    public String getTeacherName() {
        TbTeacher teacher = CACHE.getTeacher(accountId);
        if (teacher == null) {
            return "";
        }

        return teacher.getName();
    }

    /**
     * 获取专业-班级名称
     *
     * @return
     */
    public String getMajorName() {
        TbStudent student = CACHE.getStudent(accountId);
        if (student == null) {
            return "";
        }
        return CACHE.getMajorName(student.getMajorId());

    }

    /**
     * 获取角色名称列表
     *
     * @return
     */
    public String getRoleNames() {
        return CACHE.getRoleNames(roleIds);
    }


}