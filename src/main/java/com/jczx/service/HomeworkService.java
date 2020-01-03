package com.jczx.service;

import com.jczx.domain.TbAttachment;
import com.jczx.domain.TbHomework;
import com.jczx.domain.TbStudentWork;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.JDBCType;
import java.util.List;

/**
 * @author 孙文举
 * @description
 * @create 2019-12-01 22:01
 */
@Component
public class HomeworkService extends BaseService {
    @Autowired
    private AttachmentService attachmentService;

    @Override
    public String getTableName() {
        return TbHomework.class.getSimpleName();
    }

    /**
     * 添加
     *
     * @param homework
     * @return
     */
    public ServiceResult addHomework(TbHomework homework) {
        if (StringUtil.isBlank(homework.getName()) || StringUtil.isBlank(homework.getMajorId() + "") || homework.getEndTime() == null || StringUtil.isBlank(homework.getContent())) {
            return error("内容不可为空!");
        }
        homework.setCreateTime(SC.getNowDate());
        homework.setTeacherId(SC.getOperatorId());
        homework.setOperatorId(SC.getOperatorId());
        add(homework);
        return SUCCESS;
    }



    /**
     * 根据id修改
     *
     * @param homework
     * @return
     */
    public ServiceResult modifyHomework(TbHomework homework) {
        if (StringUtil.isBlank(homework.getName()) || StringUtil.isBlank(homework.getMajorId() + "") || homework.getEndTime() == null || StringUtil.isBlank(homework.getContent())) {
            return error("内容不可为空!");
        }
        modify(homework);
        return SUCCESS;
    }

    /**
     * 返回数据表格
     *
     * @param keywords
     * @param majorId
     * @param scopeTime
     * @param pager
     * @return
     */
    public List<TbHomework> list(String keywords, Integer majorId, String scopeTime, Pager pager) {
        Conditions conditions = getConditions();
        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKE("name", keywords);
            conditions.or();
            conditions.putLIKE("content", keywords);
            conditions.parenthesesEnd();
        }
        conditions.putEWIfOk("majorId", majorId);

        if (StringUtil.isNotBlank(scopeTime)) {
            String[] split = scopeTime.split(" - ");
            conditions.putBW("createTime", split[0], split[1]);

        }
        pager.setDataTotal(getCount(conditions));
        return getListByPage(conditions, pager);
    }

    public ServiceResult uploadFile(MultipartFile file, String path) {
        ServiceResult result = upload(file, path);
        Integer id=0;
        if (result.isSuccess()) {
            TbAttachment attachment = new TbAttachment();
            attachment.setCreateTime(SC.getNowDate());
            attachment.setOperatorId(SC.getOperatorId());
            attachment.setType(TbAttachment.TYPE_TEACHERFILE);
            attachment.setURL(result.getResult() + "");
            attachment.setName(file.getOriginalFilename());
            ServiceResult attachmentResult = attachmentService.addAttachment(attachment);
            id= (Integer) attachmentResult.getResult();
        }
        result.setResult(id);
        return result;
    }

}