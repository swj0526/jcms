package com.jczx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 老师表
 *
 * @author 宋家新
 * @create 2019-11-20 14:41
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbTeacher extends Domain {
    private Integer id;
    private String name;//姓名
    private String gender;//性别
    private String phone;//手机号
    private Boolean hasQuit;//老师状态//#todo 宋家新 state
    private Integer operatorId;//操作人
    private Date createTime;//操作时间

    public String getQuit() {//#todo 宋家新 静态变量
        if (hasQuit){
            return "在职";
        }else {
            return "离职";
        }
    }



}
