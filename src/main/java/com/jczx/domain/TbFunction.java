package com.jczx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 孙文举
 * @description 权限表
 * @create 2019-12-24 18:08
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbFunction extends Domain {
    private Integer id;
    private String name; //功能名称
    private Integer funCode;//功能编码
    private Integer pid;//关联上管理的功能id

}