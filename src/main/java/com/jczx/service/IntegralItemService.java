package com.jczx.service;

import com.jczx.domain.TbIntegralItem;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.apache.poi.ss.formula.functions.T;
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

    public ServiceResult addItem(TbIntegralItem integralItem) {
        if (StringUtil.isBlank(integralItem.getReason()) || integralItem.getScore() == null || StringUtil.isBlank(integralItem.getRemark())) {
            return error("");
        }
        if (integralItem.getType()==1&&integralItem.getScore()>0){
            integralItem.setScore(0-integralItem.getScore());
        }
        add(integralItem);
        return success("");
    }
    public ServiceResult modifyItem(TbIntegralItem integralItem) {
        if (StringUtil.isBlank(integralItem.getReason()) || integralItem.getScore() == null || StringUtil.isBlank(integralItem.getRemark())) {
            return error("");
        }
        if (integralItem.getType()==1&&integralItem.getScore()>0){
            integralItem.setScore(0-integralItem.getScore());
        }
        modify(integralItem);
        return success("");
    }
    public TbIntegralItem get(Integer id){
        Conditions conditions = getConditions();
        conditions.putEWIfOk("id",id);
        TbIntegralItem one = getOne(conditions);
        return one;
    }
    public String getReason(String id){
        Conditions conditions = getConditions();
        conditions.putEWIfOk("id",id);
        TbIntegralItem one = getOne(conditions);
        return one.getReason();
    }


    @Override
    public String getTableName() {
        return TbIntegralItem.class.getSimpleName();
    }
}