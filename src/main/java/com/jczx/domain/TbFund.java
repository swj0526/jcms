package com.jczx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 经费流程
 * @author 宋家新
 * @create 2019-11-18 21:09
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbFund extends Domain {
    private Integer id;
    private Integer studentId;//学生id
    private String content;//申请事由
    private String activityAmount;//申请金额
    private Date startDate;//使用日期//******use
    private Integer firstTeacherId;//一审老师
    private Boolean firstReason;//一审是否通过
    private String firstContent;//一审意见
    private Date firstOperatorTime;//一审操作时间//or e
    private Integer secondTeacherId;//二审老师
    private Boolean secondReason;//二审是否通过
    private String secondContent;//二审意见
    private Date secondOperatorTime;//二审操作时间
    private Integer operatorId;//操作人

}
