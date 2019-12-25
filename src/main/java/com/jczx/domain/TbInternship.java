package com.jczx.domain;

import com.jczx.system.CACHE;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * @author 于振华
 * @create 2019-12-24 15:04
 */

@Component
public class TbInternship extends Domain{
    private Integer id;
    private Integer studentId;//学生id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//试学开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//试学结束时间
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取专业班级名称
     * @return
     */
    public String getMajorName() {
        TbStudent student = CACHE.getStudent(studentId);
        Integer majorId = student.getMajorId();
        return CACHE.getMajorName(majorId);
    }
    /**
     * 查找学生姓名
     * @return
     */
    public String getName() {
        if (studentId==null||studentId==0){
            return null;
        }
        TbStudent student = CACHE.getStudent(studentId);
        return student.getName();
    }
}
