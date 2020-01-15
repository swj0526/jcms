package com.jczx.domain;

import com.jczx.system.CACHE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.domains.Domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**@describ 招生跟进详情表
 * @author 于振华
 * @create 2019-11-19 20:26
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbRecruitDetail extends Domain {
    private Integer id;
    private Integer studentId;//学生(招生)表id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date followTime;//跟进时间
    private Integer followCount;//第几次跟进
    private String labelIds;//跟进意向(标签)tbDictionary
    private Date createTime;//创建时间
    private Integer operatorId;//操作人
    private String remark;//备注


    /**
     * 意向标签
     *
     * @return
     */
    public String listLabelName(){
        return CACHE.getLabelNames(labelIds);
    }


}
