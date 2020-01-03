package com.jczx.domain;

import com.jczx.system.CACHE;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 于振华
 * @create 2019-12-24 15:04
 */

@Component
public class TbInternship extends Domain {
    @NotCreate
    public static final int STATE_START_TIME = 1;//开始时间
    @NotCreate
    public static final int STATE_END_TIME = 2;//结束时间
    private Integer id;
    private Integer studentId;//学生id
    private String name;//学生姓名冗余字段;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//试学开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//试学结束时间

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private Date createTime;//操作时间
    private Integer operatorId;//操作人

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取专业班级名称
     *
     * @return
     */
    public String getMajorName() {
        TbStudent student = CACHE.getStudent(studentId);
        Integer majorId = student.getMajorId();
        return CACHE.getMajorName(majorId);
    }

    /**
     * 查找学生
     *
     * @return
     */
    public TbStudent getStudent() {
        if (studentId == null || studentId == 0) {
            return null;
        }
        TbStudent student = CACHE.getStudent(studentId);
        return student;
    }

    /**
     * 查找学生性别
     *
     * @return
     */
    public String getStudentSex() {
        return getStudent().getSex();
    }

    /**
     * 查找学生性别
     *
     * @return
     */
    public String getStudentSchool() {
        return getStudent().getSchool();
    }
}
