package com.jczx.service;

import com.jczx.domain.TbIntegralHistory;
import com.jczx.domain.TbStudent;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 11:43
 */
@Component
public class IntegralHistoryService extends BaseService {
    @Autowired
    private StudentService studentService;
    @Autowired
    IntegralItemService integralItemService;

    /**
     * 查询历史记录
     *
     * @param id
     * @return
     */
    public List<TbIntegralHistory> listIntegralHistory(Integer id) {
        Conditions conditions = getConditions();
        conditions.putEWIfOk("studentId", id);
        List<TbIntegralHistory> list = getList(conditions);
        return list;
    }

    public List<TbIntegralHistory> list(String keyword, String recordTime, Integer majorId, Pager pager) {
        Conditions conditions = getConditions();
        conditions.setJoin(" integralHistory LEFT JOIN tbstudent student ON studentId=student.id");
        if (StringUtil.isNotBlank(keyword)) {
            conditions.putLIKE("student.name", keyword);
            conditions.or();
            conditions.putLIKE("integralHistory.reason", keyword);
        }
        conditions.putLIKEIfOK("student.majorId", majorId);
        if (StringUtil.isNotBlank(recordTime)) {
            String[] split = recordTime.split(" - ");
            conditions.putBW("integralHistory.recordTime", split[0], split[1]);
        }

        int count = getCount(conditions);
        pager.setDataTotal(count);
        List<TbIntegralHistory> list = getListByPage(conditions, pager);
        return list;
    }

    public ServiceResult addIntegralHistory(TbIntegralHistory integralHistory) {
        if (StringUtil.isBlank(integralHistory.getName())
                || integralHistory.getReasonId() == null
                ||integralHistory.getScore() == null
                || integralHistory.getRecordTime() == null){
            return error("必填项不能为空");
        }
        integralHistory.setCreateTime(SC.getNowDate());
        add(integralHistory);
        return SUCCESS;
    }

    public ServiceResult modify(TbIntegralHistory integralHistory) {
        if (integralHistory.getReasonId()==null || integralHistory.getScore() == null || integralHistory.getRecordTime() == null) {
            return error("必填项不能为空");
        }
        modify(integralHistory);
        return SUCCESS;
    }

    @Override
    public String getTableName() {
        return TbIntegralHistory.class.getSimpleName();
    }
}
