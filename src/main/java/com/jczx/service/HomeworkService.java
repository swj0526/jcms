package com.jczx.service;

import com.jczx.domain.TbHomework;
import com.jczx.system.SC;
import net.atomarrow.bean.ServiceResult;
import org.springframework.stereotype.Component;

/**
 * @author 孙文举
 * @description
 * @create 2019-12-01 22:01
 */
@Component
public class HomeworkService extends BaseService{
    @Override
    public String getTableName() {
        return TbHomework.class.getSimpleName();
    }

    public ServiceResult addHomework(TbHomework homework){
        homework.setCreateTime(SC.getNowDate());
        homework.setOperatorId(SC.getOperatorId());
        add(homework);
        return null;
    }
}