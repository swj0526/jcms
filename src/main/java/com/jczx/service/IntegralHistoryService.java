package com.jczx.service;

import com.jczx.domain.TbIntegralHistory;
import com.jczx.domain.TbStudent;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 11:43
 */
@Component
public class IntegralHistoryService extends BaseService {
    @Autowired
    private  StudentService studentService;
    @Autowired IntegralItemService integralItemService;


    public List<TbIntegralHistory> list(Integer id, String name) {
        Conditions conditions = getConditions();
        conditions.setJoin(" LEFT JOIN tbstudent student ON studentId=tbstudent.id");

        //conditions.putEWIfOk("TbIntegralHistory.id", id);
        conditions.putEWIfOk("tbintegralhistory.name", name);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        List<TbIntegralHistory> list = getList(conditions);
        return list;
    }

    public List<TbIntegralHistory> listIntegralHistory(String keyword, String recordTime, Integer majorId, Pager pager) {
        Conditions conditions = getConditions();
        conditions.setJoin(" integralHistory LEFT JOIN tbstudent student ON studentId=tbstudent.id");
        if (StringUtil.isNotBlank(keyword)) {
            conditions.putLIKE("student.name", keyword);
            conditions.or();
            conditions.putLIKE("integralHistory.reason", keyword);
        }
        if (StringUtil.isNotBlank(recordTime)) {
            String state = recordTime.substring(0, 19);
            String end = recordTime.substring(22);
            conditions.putBW("integralHistory.recordTime", state, end);
        }

        int count = getCount(conditions);
        pager.setDataTotal(count);
        List<TbIntegralHistory> list = getListByPage(conditions, pager);
        return list;
    }





    public ServiceResult addIntegralHistory(TbIntegralHistory integralHistory) {
        if (StringUtil.isBlank(integralHistory.getName())
                ||StringUtil.isBlank(integralHistory.getReason())
                || integralHistory.getScore() == null
                || integralHistory.getRecordTime() == null) {
            return error("必填项不能为空");
        }
        TbStudent tbStudent = studentService.get(integralHistory.getName());
        if (tbStudent!=null){
            integralHistory.setStudentId(tbStudent.getId());
        }
        add(integralHistory);
        return success("");
    }




    public ServiceResult modify(TbIntegralHistory integralHistory) {
        if (StringUtil.isBlank(integralHistory.getReason()) || integralHistory.getScore() == null || integralHistory.getRecordTime() == null) {
            return error("");
        }
        TbStudent tbStudent = studentService.get(integralHistory.getName());
        if (tbStudent!=null){
            integralHistory.setStudentId(tbStudent.getId());
        }
        modify(integralHistory);
        return success("");
    }

    @Override
    public String getTableName() {
        return TbIntegralHistory.class.getSimpleName();
    }
}
