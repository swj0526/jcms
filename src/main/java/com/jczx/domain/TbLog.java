package com.jczx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.db.annotation.FieldType;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.db.enums.Type;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description 日志表
 * @author 孙文举
 * @create 2019-11-18 16:25
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbLog  extends Domain {
    /**
     * 添加
     */
    @NotCreate
    public static final int TYPE_ADD=1;
    /**
     * 删除
     */
    @NotCreate
    public static final int TYPE_DEL=2;
    /**
     * 删除
     */
    @NotCreate
    public static final int TYPE_MOD=3;
    /**
     * 导出:有些比较重要的信息要能够看到谁导出这个数据
     */
    @NotCreate
    public static final int TYPE_EXPORT =4;
    private Integer id;
    private Integer type;//操作类型 1.增加 2.删除 3.修改
    private Integer functionId;//操作功能id
    private String IP;//操作人的ip
    @FieldType(type = Type.VARCHAR,length = 100)
    private String content; //操作内容
    private Integer operatorId;//操作人
    @FieldType(type = Type.DATETIME)
    private Date createTime;//操作时间


}