package com.jczx.bean;

import org.springframework.stereotype.Component;

/**
 * @author 孙文举
 * @description
 * @create 2019-11-20 13:58
 */
public class Function {
    /**
     * 账号管理-账号管理
     */
    public   static final int FUNC_ACCOUNT = 1001;
    public   static final String FUNC_ACCOUNT_NAME = "账号管理看                                                      ";
    /**
     * 账号管理-权限管理
     */
    public  static final int FUNC_FUNCTION = 1002;
    /**
     * 信息管理-学生档案管理
     */
    public  static final int FUNC_STUDENT = 2001;
    /**
     * 信息管理-专业管理
     */
    public  static final int FUNC_MAJOR = 202;
    /**
     * 信息管理-教职工档案管理
     */
    public  static final int FUNC_TEACHER = 203;
    /**
     * 信息管理-招生管理
     */
    public  static final int FUNC_RECRUIT = 204;
    /**
     * 信息管理-来源渠道管理
     */
    public  static final int FUNC_CHANNEL= 205;
    /**
     * 信息管理-渠道统计
     */
    public  static final int FUNC_RECRUIT_DATA = 206;
    /**
     * 流程管理-请假流程管理
     */
    public  static final int FUNC_LEAVE = 301;
    /**
     * 流程管理-经费流程管理
     */
    public  static final int FUNC_FUNDS = 302;
    /**
     * 审批管理-请假审批
     */
    public  static final int FUNC_LEAVE_CONSENT = 401;
    /**
     * 审批管理-经费审批
     */
    public  static final int FUNC_FUNDS_CONSENT= 402;
    /**
     * 缴费管理
     */
    public  static final int FUNC_PAY_BILL = 501;
    /**
     * 发文管理-发布公告
     */
    public  static final int FUNC_DISPATCH = 601;
    /**
     * 发文管理-公告列表
     */
    public  static final int FUNC_ARTICLE_LIST = 602;
    /**
     * 提醒管理-缴费提醒
     */
    public  static final int FUNC_REMIND_PAY = 701;
    /**
     * 提醒管理-公告提醒
     */
    public  static final int FUNC_REMIND_ARTICLE = 702;
    /**
     * 作业管理-上传作业
     */
    public  static final int FUNC_HOMEWORK = 801;
    /**
     * 作业管理-作业列表
     */
    public  static final int FUNC_HOMEWORK_LIST = 802;
    /**
     * 积分管理-查看积分
     */
    public  static final int FUNC_INTEGRAL_LIST = 901;
    /**
     * 积分管理-修改积分
     */
    public  static final int FUNC_MOD_INTEGRAL = 902;




}