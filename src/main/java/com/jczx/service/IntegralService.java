package com.jczx.service;

import com.jczx.domain.TbIntegral;
import net.atomarrow.bean.Pager;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 10:32
 */
@Component
public class IntegralService extends BaseService {

    public List<TbIntegral> list(String keyword, Integer start, Integer end, Pager pager) {
        Conditions conditions = getConditions();
        conditions.setJoin(" LEFT JOIN tbstudent ON studentId=tbstudent.id");
        if (StringUtil.isNotBlank(keyword)) {

            conditions.putLIKE("name", keyword);
            conditions.or();
            conditions.putLIKE("totalScore", keyword);
        }
        if (start != null && end != null) {
            conditions.putBW("totalScore", start, end);
        }
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        List<TbIntegral> list = getListByPage(conditions,pager);
        return list;
    }

    @Override
    public String getTableName() {
        return TbIntegral.class.getSimpleName();
    }
}
