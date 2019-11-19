package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * 经费流程
 * @author 宋家新
 * @create 2019-11-18 21:09
 */
@Component
public class TbFunds extends Domain {
    private Integer id;
    private String name;//学生姓名
    private String cause;//申请事由
    private String money;//申请金额
    private String apply;//申请日期
    private String start;//开始日期
    private String ontTrial;//一审老师
    private String oneReason;//一审意见
    private String oneAdopt;//一审意见
    private String twoTrial;//二审老师
    private String twoAdopt;//二审是否通过
    private String twoReason;//二审意见

}
