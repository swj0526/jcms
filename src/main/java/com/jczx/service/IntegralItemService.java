package com.jczx.service;

import com.jczx.domain.TbIntegralItem;
import net.atomarrow.db.parser.Conditions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-29 13:40
 */
@Component
public class IntegralItemService extends BaseService{

    public List<TbIntegralItem>list(){
        Conditions conditions = getConditions();
        return null;
    }





    @Override
    public String getTableName() {
        return TbIntegralItem.class.getSimpleName();
    }
}
