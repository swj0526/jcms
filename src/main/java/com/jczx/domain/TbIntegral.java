package com.jczx.domain;

import com.jczx.system.CACHE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 学生积分列表
 *
 * @author 池炯武
 * @create 2019-11-17 12:57
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbIntegral extends Domain {
    private Integer id;
    private Integer studentId;// 学生id
    private Integer totalScore;//总分
    private Integer operatorId;//操作人
    private Date createTime;//操作时间

    public String getName() {
        return CACHE.getStudentName(studentId);
    }
    public String getMajorName() {
        return CACHE.getMajorName(CACHE.getStudent(studentId).getMajorId());
    }


}