package com.jczx.service;

import com.jczx.domain.TbHomework;
import com.jczx.system.SC;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

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
     * 添加作业 //todo缺时间
     * @param homework
     * @return
     */
    public ServiceResult addHomework(TbHomework homework) {
        if (StringUtil.isBlank(homework.getName()) || StringUtil.isBlank(homework.getMajorId() + "") || StringUtil.isBlank(homework.getContent())) {
            return error("");
        }
        homework.setCreateTime(SC.getNowDate());
        homework.setOperatorId(SC.getOperatorId());
         add(homework);
        return SUCCESS;
    }
}