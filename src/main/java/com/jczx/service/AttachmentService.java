package com.jczx.service;

import com.jczx.domain.TbAttachment;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @author 孙文举
 * @description 操作附件表
 * @create 2019-12-12 12:25
 */
@Component
public class AttachmentService extends BaseService {
    @Override
    public String getTableName() {
        return TbAttachment.class.getSimpleName();
    }

    /**
     * 添加附件
     *
     * @param attachment
     * @return
     */
    public ServiceResult addAttachment(TbAttachment attachment) {
        add(attachment);
        return success(attachment.getId());
    }

    /**
     * 根据id修改指定的linkId列
     *
     * @param attachmentId
     * @return
     */
    public ServiceResult modifyAttachment(Integer attachmentId, Integer homeworkId) {
        Conditions conditions = getConditions();
        conditions.putEW("id", attachmentId);
        modifyWithColumn(conditions, new Serializable[]{"linkId", homeworkId});
        return SUCCESS;
    }

    /**
     * 根据类型跟linkId来查找附件
     *
     * @param linkId
     * @return
     */
    public TbAttachment getAttachment(Integer linkId, Integer type) {
        Conditions conditions = getConditions();
        conditions.putEW("linkId", linkId);
        conditions.putEW("type", type);
        TbAttachment attachment = getOne(conditions);
        return attachment;
    }

    /**
     * 删除附件
     *
     * @param linkId
     * @param type
     * @return
     */
    public ServiceResult deleteAttachment(Integer linkId, Integer type) {
        Conditions conditions = getConditions();
        conditions.putEW("linkId",linkId);
        conditions.putEW("type",type);
        TbAttachment attachment = getOne(conditions);
        String url = attachment.getURL();
        del(attachment);
        File file = new File(url);
        file.delete();
        return SUCCESS;
    }
}