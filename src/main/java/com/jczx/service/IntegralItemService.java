package com.jczx.service;

import com.jczx.domain.TbIntegralItem;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 13:40
 */
@Component
public class IntegralItemService extends BaseService {

    public List<TbIntegralItem> list() {
        Conditions conditions = getConditions();
        List<TbIntegralItem> list = getList(conditions);
        return list;
    }

    public ServiceResult add(TbIntegralItem integralItem) {
        if (StringUtil.isBlank(integralItem.getReason())
                || integralItem.getScore() == null
                || StringUtil.isBlank(integralItem.getRemark())) {
            return error("");
        }
        add(integralItem);
        return success("");
    }


    @Override
    public String getTableName() {
        return TbIntegralItem.class.getSimpleName();
    }
}
