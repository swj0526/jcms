package com.jczx.service;

import com.jczx.domain.TbIntegral;
import net.atomarrow.bean.Pager;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 10:32
 */
@Component
public class IntegralService extends BaseService {

    public List<TbIntegral> list(String keyword, Integer ScoreA, Integer ScoreB, Pager pager) {
        Conditions conditions = new Conditions(getTableName());
        if (StringUtil.isNotBlank(keyword)) {
            conditions.putLIKE("name", keyword);
            conditions.putLIKE("totalScore", keyword);
        }
        if (ScoreA != null && ScoreB != null) {
            conditions.putBW("totalScore", ScoreA, ScoreB);
        }
        List<TbIntegral> list = getListByPage(conditions,pager);
        return list;
    }

    @Override
    public String getTableName() {
        return TbIntegral.class.getSimpleName();
    }
}
