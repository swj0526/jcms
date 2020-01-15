package com.jczx.domain;

import com.jczx.system.CACHE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 学生作业上传表
 *
 * @author 丛枭钰
 * @create 2019-11-19 13:58
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbStudentWork extends Domain {
    private Integer id;
    private Integer studentId;//学生表id
    private Integer homeworkId;//作业id//homeworkId
    private Boolean hasAttachment;//是否有附件//
    private String content;//内容
    private String estimateContent;//评价
    private Integer score;//分数
    private Integer teacherId;//评价老师
    private Integer operatorId;//操作人id
    private Date createTime;//操作时间
    @NotCreate
    private List<TbAttachment> list;

    public List<TbAttachment> getList() {
        return list;
    }

    public void setList(List<TbAttachment> list) {
        this.list = list;
    }

    public String getName() {
        return CACHE.getStudentName(studentId);
    }

    public String getMajor() {

        return CACHE.getMajorName(studentId);
    }


}
