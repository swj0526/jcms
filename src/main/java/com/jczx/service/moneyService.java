package com.jczx.service;

import com.jczx.bean.PayBillBean;
import com.jczx.domain.TbPayBill;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 缴费
 *
 * @author 丛枭钰
 * @create 2019-11-21 21:37
 */
@Component
public class moneyService extends Service {
    /**
     * 添加
     *
     * @param payBill
     * @return
     */
    public ServiceResult addBill(TbPayBill payBill) {
        Serializable add = add(payBill);
        return success('1');
    }

    /**
     * 修改
     *
     * @return
     */
    public ServiceResult modifyBill(TbPayBill payBill) {
        int modify = modify(payBill);
        return success(1);
    }

    /**查询
     * @return
     */
    public List<PayBillBean> listBill(Pager pager) {
        Conditions conditions = new Conditions(TbPayBill.class);
        List<PayBillBean> list = getListByPage(conditions, pager);
        return list;
    }

    /**
     * 修改查询
     * @param id
     * @return
     */
    public PayBillBean getBill(int id) {
        Conditions conditions = new Conditions(TbPayBill.class);
        conditions.putEW("id",id);
        PayBillBean PayBillBean = getOne(conditions);
        return PayBillBean;
    }

    public int getCount() {
        Conditions conditions = new Conditions(TbPayBill.class);
        int count = getCount(conditions);
        return count;
    }

}
