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

    //#todo 丛
    public List<TbIntegralHistory> listIntegralHistory(Integer id, String name) {
        Conditions conditions = getConditions();
        conditions.setJoin(" integralHistory  LEFT JOIN tbstudent student  ON studentId=student.id");

        conditions.putEWIfOk("student.id", id);
        conditions.putEWIfOk("student.name", name);//#todo 丛
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
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
        if (StringUtil.isNotBlank(recordTime)) {//#todo 丛
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
        return SUCCESS;
    }




    public ServiceResult modify(TbIntegralHistory integralHistory) {
        if (StringUtil.isBlank(integralHistory.getReason()) || integralHistory.getScore() == null || integralHistory.getRecordTime() == null) {
            return error("必填项不能为空");
        }
        TbStudent tbStudent = studentService.get(integralHistory.getName());
        if (tbStudent!=null){
            integralHistory.setStudentId(tbStudent.getId());
            return error("没有该学生生");
        }
        modify(integralHistory);
        return SUCCESS;
    }

    @Override
    public String getTableName() {
        return TbIntegralHistory.class.getSimpleName();
    }
}
