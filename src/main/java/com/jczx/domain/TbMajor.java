package com.jczx.domain;

import com.jczx.system.OptionInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 专业表
 * @author 孙文举
 * @create 2019-11-20 14:51
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbMajor extends Domain implements OptionInterface {
    private Integer id;
    private String name; //专业名称
    private Integer pid; //班级关联
    private Integer operatorId;//操作人
    private Date createTime;//操作时间
    private String remark;//备注
    //操作人,时间



    @Override
    public String getOptionText() {
        return name;
    }

    @Override
    public String getOptionValue() {
        return id+"";
    }
}
