package com.jczx.service;

import com.jczx.domain.TbIntegral;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import javax.naming.directory.SearchResult;
import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 10:32
 */
@Component
public class IntegralService extends BaseService {
    public ServiceResult addList(Integer studentId) {
        TbIntegral integral=new TbIntegral();
        integral.setStudentId(studentId);
        integral.setTotalScore(100);
        integral.setCreateTime(SC.getNowDate());
        add(integral);
        return SUCCESS;
    }

    public List<TbIntegral> list(String keyword, Integer start, Integer end, Pager pager) {
        Conditions conditions = getConditions();
        conditions.setJoin(" Integral LEFT JOIN tbstudent student ON studentId=student.id");
        if (StringUtil.isNotBlank(keyword)) {

            conditions.putLIKE("student.name", keyword);
            conditions.or();
            conditions.putLIKE("Integral.totalScore", keyword);
        }
        if (start != null && end != null) {
            conditions.putBW("Integral.totalScore", start, end);
        }
        if (pager == null) {
            List<TbIntegral> list = getList(conditions);
            System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
            return list;
        }
        List<TbIntegral> list = getListByPage(conditions, pager);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return list;
    }


    @Override
    public String getTableName() {
        return TbIntegral.class.getSimpleName();
    }
}
