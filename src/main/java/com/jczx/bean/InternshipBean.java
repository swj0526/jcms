package com.jczx.bean;

import com.jczx.domain.TbStudent;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 于振华
 * @create 2019-12-29 9:16
 */
public class InternshipBean extends TbStudent {
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//试学开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//试学结束时间

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
