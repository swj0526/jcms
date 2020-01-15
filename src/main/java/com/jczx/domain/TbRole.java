package com.jczx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description 角色类
 * @author 孙文举
 * @create 2019-11-18 16:11
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbRole extends Domain {
    private Integer id;
    private String name;//角色名称
    private Boolean state;//角色状态为true的,则不可删除该角色
    private String remark;//角色备注
    @FieldType(type = Type.VARCHAR,length = 255)
    private String functionIds;//权限列表
    private Integer operatorId;//操作人
    private Date createTime;//操作时间



    public String getFunctionIds() {

        return functionIds;
    }


}