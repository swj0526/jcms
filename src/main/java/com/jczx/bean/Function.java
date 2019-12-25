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
    public static final int FUNC1 = 1000;
    public static final String FUNC1_NAME = "账号管理";

    public static final int FUNC_ACCOUNT = 1001;
    public static final String FUNC_ACCOUNT_NAME = "账号角色管理";
    /**
     * 账号管理-角色权限管理
     */
    public static final int FUNC_FUNCTION = 1002;
    public static final String FUNC_FUNCTION_NAME = "角色权限管理";
    /**
     * 信息管理-学生档案管理
     */

    public static final int FUNC2 = 2000;
    public static final String FUNC2_NAME = "信息管理";

    public static final int FUNC_STUDENT = 2001;
    public static final String FUNC_STUDENT_NAME = "学生档案管理";
    /**
     * 信息管理-专业管理
     */
    public static final int FUNC_MAJOR = 2002;
    public static final String FUNC_MAJOR_NAME = "专业-班级管理";
    /**
     * 信息管理-教职工档案管理
     */
    public static final int FUNC_TEACHER = 2003;
    public static final String FUNC_TEACHER_NAME = "教职工档案管理";
    /**
     * 信息管理-招生管理
     */
    public static final int FUNC_RECRUIT = 2004;
    public static final String FUNC_RECRUIT_NAME = "招生信息管理";
    /**
     * 信息管理-试课学生管理
     */
    public static final int FUNC_LISTENING = 2005;
    public static final String FUNC_LISTENING_NAME = "试课学生管理";
    /**
     * 信息管理-来源渠道管理
     */
    public static final int FUNC_CHANNEL = 2006;
    public static final String FUNC_CHANNEL_NAME = "来源渠道管理";
    /**
     * 信息管理-渠道统计
     */
    public static final int FUNC_RECRUIT_DATA = 2007;
    public static final String FUNC_RECRUIT_DATA_NAME = "渠道统计";
    /**
     * 流程管理-流程管理
     */
    public static final int FUNC3 = 3000;
    public static final String FUNC3_NAME = "流程管理";
    /**
     * 流程管理-请假流程管理
     */
    public static final int FUNC_LEAVE = 3001;
    public static final String FUNC_LEAVE_NAME = "请假流程管理";
    /**
     * 流程管理-经费流程管理
     */
    public static final int FUNC_FUNDS = 3002;
    public static final String FUNC_FUNDS_NAME = "经费流程管理";
    /**
     * 审批管理
     */
    public static final int FUNC4 = 4000;
    public static final String FUNC4_NAME = "审批管理";
    /**
     * 审批管理-请假审批
     */
    public static final int FUNC_LEAVE_CONSENT = 4001;
    public static final String FUNC_LEAVE_CONSENT_NAME = "请假审批";
    /**
     * 审批管理-经费审批
     */
    public static final int FUNC_FUNDS_CONSENT = 4002;
    public static final String FUNC_FUNDS_CONSENT_NAME = "经费审批";
    /**
     * 缴费管理
     */
    public static final int FUNC_PAY_BILL = 5001;
    public static final String FUNC_PAY_BILL_NAME = "缴费管理";
    /**
     * 发文管理
     */
    public static final int FUNC6 = 6000;
    public static final String FUNC6_NAME = "发文管理";

    /**
     * 发文管理-发布公告
     */
    public static final int FUNC_DISPATCH = 6001;
    public static final String FUNC_DISPATCH_NAME = "发布信息";
    /**
     * 发文管理-公告列表
     */
    public static final int FUNC_NOTICE_LIST = 6002;
    public static final String FUNC_NOTICE_LIST_NAME = "公告列表";
    /**
     * 发文管理-文章列表
     */
    public static final int FUNC_ARTICLE_LIST = 6003;
    public static final String FUNC_ARTICLE_LIST_NAME = "文章列表";
    /**
     * 提醒管理
     */
    public static final int FUNC7 = 7000;
    public static final String FUNC7_NAME = "提醒管理";
    /**
     * 提醒管理-缴费提醒
     */
    public static final int FUNC_REMIND_PAY = 7001;
    public static final String FUNC_REMIND_PAY_NAME = "缴费提醒";
    /**
     * 提醒管理-公告提醒
     */
    public static final int FUNC_REMIND_ARTICLE = 7002;
    public static final String FUNC_REMIND_ARTICLE_NAAME = "公告提醒";
    /**
     * 作业管理
     */
    public static final int FUNC8 = 8000;
    public static final String FUNC8_NAME = "作业管理";
    /**
     * 作业管理-上传作业
     */
    public static final int FUNC_HOMEWORK = 8001;
    public static final String FUNC_HOMEWORK_NAME = "上传作业";
    /**
     * 作业管理-作业列表
     */
    public static final int FUNC_HOMEWORK_LIST = 8002;
    public static final String FUNC_HOMEWORK_LIST_NAME = "作业列表";
    /**
     * 积分管理
     */
    public static final int FUNC9 = 9000;
    public static final String FUNC9_NAME = "积分管理";
    /**
     * 积分管理-查看积分
     */
    public static final int FUNC_INTEGRAL_LIST = 9001;
    public static final String FUNC_INTEGRAL_LIST_NAME = "查看积分";
    /**
     * 积分管理-修改积分
     */
    public static final int FUNC_MOD_INTEGRAL = 9002;
    public static final String FUNC_MOD_INTEGRAL_NAME = "修改积分";


}