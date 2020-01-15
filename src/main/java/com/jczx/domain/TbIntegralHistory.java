package com.jczx.domain;

import com.jczx.system.CACHE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 丛枭钰
 * @create 2019-11-29 11:30
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbIntegralHistory extends Domain {
    private Integer id;//id
    private Integer studentId;//学生id
    @FieldType(type = Type.DATETIME)
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date recordTime;//事发时间
    private Integer reasonId;//事由Id
    private Integer score;//分数
    private String remark;//备注
    private Integer operatorId;//操作人
    private Date createTime;//操作时间

    public String getReasonName(){

        return CACHE.getIntegralItemName(reasonId);
    }

    public String getName() {
        return CACHE.getStudentName(studentId);
    }
    public String getMajorName() {

        return CACHE.getMajorName(CACHE.getStudent(studentId).getMajorId());
    }


}

