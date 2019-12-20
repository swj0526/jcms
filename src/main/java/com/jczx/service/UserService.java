package com.jczx.service;

import com.jczx.domain.TbStudent;
import com.jczx.domain.TbUser;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 孙文举
 * @description 用户表进行操作
 * @create 2019-12-20 0:51
 */
@Component
public class UserService extends BaseService {

    /**
     * 新增账号
     *
     * @param student
     * @return
     */
    public ServiceResult addUser(TbStudent student) {
        TbUser user = new TbUser();
        user.setType(TbUser.TYPE_STUDENT);
        user.setAccountId(student.getId());
        user.setPhone(student.getStudentPhone());
        user.setPassword("123456");
        user.setCreateTime(SC.getNowDate());
        user.setOperatorId(SC.getOperatorId());
        add(user);
        return SUCCESS;

    }

    /**
     * 锁定账号
     *
     * @param user
     * @return
     */
    public ServiceResult cancelUser(TbUser user) {

        user.setEnable(TbUser.TYPE_NO_ENABLE);
        modify(user);

        return SUCCESS;

    }

    /**
     * 激活账号
     *
     * @param user
     * @return
     */
    public ServiceResult activateUser(TbUser user) {
        user.setEnable(TbUser.TYPE_ENABLE);
        modify(user);
        return SUCCESS;

    }

    /**
     * 用户列表
     *
     * @param keywords
     * @param pager
     * @return
     */
    public List<TbUser> listUser(String keywords, Pager pager) {
        Conditions conditions = getConditions();
        return getListByPage(conditions, pager);
    }

    @Override
    public String getTableName() {
        return TbUser.class.getSimpleName();
    }
}