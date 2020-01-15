package com.jczx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 请假流程
 *
 * @author 宋家新
 * @create 2019-11-18 21:09
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbLeave extends Domain {

    private Integer id;
    private Integer studentId;//学生姓名
    private Date leaveTime; //请假时间//start
    private Date endTime;//结束时间
    private Date createTime;//申请时间
    private String content;//请假事由
    private Double dayCount;//请假天数
    private Integer firstTeacherId;//一审老师
    private Boolean firstState;//一审是否通过
    private String firstContent;//一审意见
    private Date firstOperatorTime;//一审操作时间/***e
    private Integer secondTeacherId;//二审老师
    private String secondContent;//二审意见
    private Boolean secondState;//二审是否通过
    private Date secondOperatorTime;//二审操作时间
    private Integer operatorId;//操作人,学生id

}
