package com.jczx.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author 于振华
 * @create 2019-12-15 20:22
 */
@Data
public class RemindBean {
    private String name;//学生姓名
    private String majorName;//专业姓名
    private Date payDate;//上次缴费日期
    private Integer factAmount;//上次实付金额
    private Date startTime;//开始时间
    private Date endTime;//结束时间

}
