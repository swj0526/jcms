package com.jczx.domain;

import com.jczx.system.CACHE;
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
 * 发布文章
 * @author 宋家新
 * @create 2019-11-18 21:11
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbArticle extends Domain {
    @NotCreate
    private String quit;
    private Integer id;
    private String title;//标题
    private String receiverRoleIds;//接收人,长度40够用
    private Integer typeId;//文章类型
    @FieldType(type = Type.TEXT)
    private String content;//内容
    private Integer state;//状态 1.草稿，2.已撤销，3.已提交
    private Integer readCount;//已读数//count
    private Integer totalCount;//应读数//count
    @FieldType(type = Type.VARCHAR,length = 100)
    private String readIds;//已读
    @FieldType(type = Type.VARCHAR,length = 100)
    private String totalIds;//应读
    private Boolean hasAttachment;//是否有上传文件
    private Date createTime;//发布时间
    private Integer operatorId;//操作人

    public String getQuit() {
        if (state == 1) {
            return "草稿";
        }
        if (state == 2) {
            return "已撤销";
        }
        if (state == 3) {
            return "已提交";
        }
        return null;
    }



    public String getTypeName() {
        return CACHE.getArticleTypeName(typeId);
    }
}
