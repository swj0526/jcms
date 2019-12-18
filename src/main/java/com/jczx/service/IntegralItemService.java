package com.jczx.service;

import com.jczx.domain.TbIntegralItem;
import com.jczx.system.SC;
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
    /**
     * 查询列表
     * @return
     */
    public List<TbIntegralItem> list() {
        Conditions conditions = getConditions();
        List<TbIntegralItem> list = getList(conditions);
        return list;
    }
    /**
     * 添加
     * @param integralItem
     * @return
     */
    public ServiceResult addItem(TbIntegralItem integralItem) {
        if (StringUtil.isBlank(integralItem.getReason()) || integralItem.getScore() == null) {
            return error("必选项为空");
        }
        if (integralItem.getType()==1&&integralItem.getScore()>0){
            integralItem.setScore(0-integralItem.getScore());
        }
        integralItem.setCreateTime(SC.getNowDate());
        add(integralItem);
        return SUCCESS;
    }

    /**
     * 修改
     * @param integralItem
     * @return
     */
    public ServiceResult modifyItem(TbIntegralItem integralItem) {
        if (StringUtil.isBlank(integralItem.getReason()) || integralItem.getScore() == null) {
            return error("");
        }
        if (integralItem.getType()==1&&integralItem.getScore()>0){
            integralItem.setScore(0-integralItem.getScore());
        }
        modify(integralItem);
        return success("");
    }

    /**
     * 查询分数
     * @param id
     * @return
     */
    public TbIntegralItem get(Integer id){
        Conditions conditions = getConditions();
        conditions.putEWIfOk("id",id);
        TbIntegralItem IntegralItem = getOne(conditions);
        return IntegralItem;
    }



    @Override
    public String getTableName() {
        return TbIntegralItem.class.getSimpleName();
    }
}
