package com.jczx.domain;

import com.jczx.system.OptionInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.db.annotation.NotCreate;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 于振华
 * @describe 字典表
 * @create 2019-11-18 23:32
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbDictionary extends Domain implements OptionInterface {
    /**
     *  意向标签
     */
    @NotCreate
    public static final int TYPE_LABEL = 1;
    /**
     * 渠道
     */
    @NotCreate
     public static final int TYPE_CHANNEL = 2;
    /**
     * 缴费类型
     */
    @NotCreate
    public static final int TYPE_PAY_BILL = 3;
    /**
     * 缴费方式
     */
    @NotCreate
    public static final int TYPE_PAY = 4;
    /**
     * 学年,学期
     */
    @NotCreate
    public static final int TYPE_TERM = 5;
    /**
     * 发文类型
     */
    @NotCreate
    public static final int TYPE_DISPATCH = 6;
    private Integer id;
    private String name;
    private Integer type;//字典表类型
    private String remark;//备注
    private Date createTime;//创建时间
    private Integer operatorId;//操作人


    @Override
    public String getOptionText() {
        return name;
    }

    @Override
    public String getOptionValue() {
        return id+"";
    }



}
