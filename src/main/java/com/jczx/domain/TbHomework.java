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
 * 发布作业表
 *
 * @author 丛枭钰
 * @create 2019-11-19 13:25
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbHomework extends Domain {
    private Integer id;
    private String name;//作业名称
    private Integer teacherId;//发布人
    private Integer majorId;//班级专业
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;//截止日期
    @FieldType(type = Type.TEXT)
    private String content;//内容//长度问题
    private Boolean hasAttachment;//是否有附件
    private Integer submitCount;//提交人数
    @FieldType(type = Type.VARCHAR, length = 255)
    private String submitIds;//已提交人
    @FieldType(type = Type.VARCHAR, length = 255)
    private String notSubmitIds;//未提交人
    private Integer totalCount;//总人数
    private Integer operatorId;//操作人id
    @FieldType(type = Type.TEXT)
    private String remark;//备注
    private Date createTime;//创建时间



    public String getMajorName() {

        return CACHE.getMajorName(majorId);
    }

    public String getTeacherName() {

        return CACHE.getTeacherName(teacherId);
    }
}
