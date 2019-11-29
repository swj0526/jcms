package com.jczx.service;

import com.jczx.domain.TbIntegralHistory;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 11:43
 */
@Component
public class IntegralHistoryService extends BaseService {
    public List<TbIntegralHistory> list(Integer id,String name){
        Conditions conditions = getConditions();
        conditions.setJoin(" LEFT JOIN tbstudent ON studentId=tbstudent.id");

        conditions.putEWIfOk("TbIntegralHistory.id",id);
        conditions.putEWIfOk("name",name);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        List<TbIntegralHistory> list = getList(conditions);
        return list;
    }

    public List<TbIntegralHistory> HistoryList(String keyword, String recordTime, Integer major, Pager pager){
        Conditions conditions = getConditions();
        conditions.setJoin(" LEFT JOIN tbstudent ON studentId=tbstudent.id");
        if (StringUtil.isNotBlank(keyword)){
            conditions.putLIKE("name",keyword);
            conditions.putLIKE("reason",keyword);
        }
        if (StringUtil.isNotBlank(recordTime)){
            String state=recordTime.substring(0,16);
            String end=recordTime.substring(22);
            conditions.putBW("recordTime",state,end);
        }
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        int count = getCount(conditions);
        pager.setDataTotal(count);
        List<TbIntegralHistory> list = getListByPage(conditions,pager);
        return list;
    }

    @Override
    public String getTableName() {
        return TbIntegralHistory.class.getSimpleName();
    }
}
