package com.jczx.service;

import com.jczx.domain.TbHomework;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 孙文举
 * @description
 * @create 2019-12-01 22:01
 */
@Component
public class HomeworkService extends BaseService {
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
            return error("");
        }
        homework.setCreateTime(SC.getNowDate());
        homework.setTeacherId(SC.getOperatorId());
        homework.setOperatorId(SC.getOperatorId());
        add(homework);
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
        conditions.putLIKEIfOK("majorId", majorId);

        if (StringUtil.isNotBlank(scopeTime)) {
            String start = scopeTime.substring(0, 10);
            String end = scopeTime.substring(13);
            conditions.putBW("createTime", start, end);

        }
        pager.setDataTotal(getCount(conditions));
        return getListByPage(conditions, pager);
    }

    public TbHomework getHomework(Integer id) {
        return getById(getTableName(), id);
    }
}