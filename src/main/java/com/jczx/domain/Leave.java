package com.jczx.domain;

/**
 * 请假流程
 * @author 宋家新
 * @create 2019-11-18 21:09
 */
public class Leave {
    private Integer id;
    private String name;//学生姓名
    private String leaveTime; //请假时间
    private String endTime;//结束时间
    private String apply;//申请时间
    private String cause;//请假事由
    private String days;//请假天数
    private String oneTrial;//一审老师
    private String oneAdopt;//一审是否通过
    private String oneReason;//一审意见
    private String twoTrial;//二审老师
    private String twoAdopt;//二审是否通过
    private String twoReason;//二审意见
}
