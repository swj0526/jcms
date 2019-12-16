package com.jczx.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 于振华
 * @create 2019-12-15 20:22
 */
public class RemindBean {
    private Integer numberStudent;//学号
    private String name;//学生姓名
    private Integer majorId;//专业id
    private Integer pid; //班级关联
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date payDate;//上次缴费日期
    private Integer factAmount;//上次实付金额
}
