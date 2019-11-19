package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 丛枭钰
 * @create 2019-11-19 13:25
 */
@Component
public class TbWork extends Domain {
   private Integer id;
   private Integer TbStudentId;//学生表id
   private  Integer TbWorkListId;//作业列表id
    private String file;//作业文件
    private  Integer score;//分数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTbStudentId() {
        return TbStudentId;
    }

    public void setTbStudentId(Integer tbStudentId) {
        TbStudentId = tbStudentId;
    }

    public Integer getTbWorkListId() {
        return TbWorkListId;
    }

    public void setTbWorkListId(Integer tbWorkListId) {
        TbWorkListId = tbWorkListId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}