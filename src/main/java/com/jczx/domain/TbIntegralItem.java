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
 * 事由表
 *
 * @author 池炯武
 * @create 2019-11-20 19:30
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbIntegralItem extends Domain implements OptionInterface {
    /**
     * 加分
     */
    @NotCreate
    public static final int TYPE_ADD = 1;
    /**
     * 减分
     */
    @NotCreate
    public static final int TYPE_SUBTRACT = 2;
    private Integer id;
    private Integer score;//记录加分减分
    private String reason;//事由
    private Integer type;//判断加分减分
    private String remark;//备注
    private Integer operatorId;//操作人
    private Date createTime;//操作时间
    @Override
    public String getOptionText() {
        return reason;
    }

    @Override
    public String getOptionValue() {
        return ""+id+"";
    }
}
