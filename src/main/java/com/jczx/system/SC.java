package com.jczx.system;

import java.util.Date;

/**
 * @author 孙文举
 * @description sessionController 里面放一些项目共用数据
 * @create 2019-11-22 14:02
 */
public class SC {

    public static Date getNowDate(){
     Date date = new Date();
     return date;
    }

    public static int getOperatorId(){
        //ToDo 孙文举 从session中获取登录用户的id.
        return 1;
    }

}