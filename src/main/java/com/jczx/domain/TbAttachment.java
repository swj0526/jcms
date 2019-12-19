package com.jczx.domain;

import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 附件表
 *
 * @author 丛枭钰
 * @create 2019-11-20 14:00
 */
@Component
public class TbAttachment extends Domain {
    /**
     * 导入的excel 类型
     */
    @NotCreate
    public static final int TYPE_EXCEL = 1;
    /**
     * 老师上传作业类型
     */
    @NotCreate
    public static final int TYPE_TEACHERFILE = 2;
    /**
     * 学生上传作业类型
     */
    @NotCreate
    public static final int TYPE_STUDENTFILE = 3;
    /**
     * 发布的文章,公告类型
     */
    @NotCreate
    public static final int TYPE_ARTICLE = 4;
    /**
     * 上传的发票
     */
    @NotCreate
    public static final int TYPE_BILL = 5;
    private Integer id;
    private Integer type;//类型,静态变量
    private Integer linkId;//数据链接id
    private Integer studentId;//学生id
    @FieldType(type = Type.TEXT)
    private String URL;//附件地址
    private String name;//文件名称
    private Integer operatorId;//操作人id
    private Date createTime;//创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
