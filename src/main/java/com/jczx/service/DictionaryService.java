package com.jczx.service;

import com.jczx.domain.TbArticle;
import com.jczx.domain.TbDictionary;
import com.jczx.domain.TbPayBill;
import com.jczx.domain.TbStudent;
import com.jczx.system.SC;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 孙文举
 * @description 字典表的增删改查
 * @create 2019-11-22 8:41
 */
@Component
public class DictionaryService extends BaseService {

    @Autowired
    public StudentService studentService;
    @Autowired
    public PayBIllService moneyService;
    @Autowired
    public ArticleService articleService;

    @Override
    public String getTableName() {
        return TbDictionary.class.getSimpleName();
    }

    /**
     * 增加字典表
     *
     * @param
     * @return
     */
    public ServiceResult addDictionary(String name, String remark, Integer type) {
        TbDictionary dictionary = new TbDictionary();
        if (StringUtil.isBlank(name)) {
            return error("名称不可为空!");
        }
        dictionary.setName(name);
        dictionary.setRemark(remark);
        dictionary.setType(type);
        dictionary.setCreateTime(SC.getNowDate());
        dictionary.setOperatorId(SC.getOperatorId());
        add(dictionary);
        return SUCCESS;
    }

    /**
     * 修改字典信息
     *
     * @param name
     * @param remark
     * @param id
     * @return
     */
    public ServiceResult modifyDictionary(String name, String remark, Integer id) {
        if (StringUtil.isBlank(name)) {
            return error("名称不可为空!");
        }
        TbDictionary dictionary = getById(id);
        dictionary.setName(name);
        dictionary.setRemark(remark);
        modify(dictionary);
        return SUCCESS;
    }

    /**
     * 删除渠道
     *
     * @param id
     * @return
     */
    public ServiceResult deleteChannel(Integer id) {
        List<TbStudent> list = studentService.channelCount(id);
        if (list.size() != 0) {
            return error("该渠道有学生,不可删除!");
        }
        delById(getTableName(), id);
        return SUCCESS;
    }

    /**
     * 删除学年
     *
     * @param id
     * @return
     */
    public ServiceResult deleteTerm(Integer id) {
        List<TbPayBill> list = moneyService.termCount(id);
        if (list.size() != 0) {
            return error("有学生是该学年进行缴费的,不可删除!");
        }
        delById(getTableName(), id);
        return SUCCESS;
    }

    /**
     * 删除缴费类型
     *
     * @param id
     * @return
     */
    public ServiceResult deleteType(Integer id) {
        List<TbPayBill> list = moneyService.typeCount(id);
        if (list.size() != 0) {
            return error("有学生是使用该缴费类型进行缴费的,不可删除!");
        }
        delById(getTableName(), id);
        return SUCCESS;
    }

    /**
     * 删除缴费方式
     *
     * @param id
     * @return
     */
    public ServiceResult deleteMethod(Integer id) {
        List<TbPayBill> list = moneyService.methodCount(id);
        if (list.size() != 0) {
            return error("有学生是使用该缴费方式进行缴费的,不可删除!");
        }
        delById(getTableName(), id);
        return SUCCESS;
    }

    /**
     * 删除缴费方式
     *
     * @param id
     * @return
     */
    public ServiceResult deleteArticleType(Integer id) {
        List<TbArticle> list = articleService.checkType(id);
        if (list.size() != 0) {
            return error("现有公告是此类型,不可删除!");
        }
        delById(getTableName(), id);
        return SUCCESS;
    }

    /**
     * 根据类型从字典表中取数据
     *
     * @param
     * @return
     */
    public List<TbDictionary> list(Integer type, String keywords, Pager pager) {
        Conditions conditions = getConditions();
        conditions.putEW("type", type);
        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKEIfOK("name", keywords);
            conditions.or();
            conditions.putLIKEIfOK("remark", keywords);
            conditions.parenthesesEnd();
        }
        if (pager == null) {
            return getList(conditions);
        }
        pager.setDataTotal(getCount(conditions));
        List<TbDictionary> list = getListByPage(conditions, pager);

        return list;
    }

    /**
     * 缴费方式从字典表中取数据
     *
     * @param
     * @return
     */
    public List<TbDictionary> listPayWay(Integer type) {
        Conditions conditions = getConditions();
        conditions.putEW("type", type);
        List<TbDictionary> list = getList(conditions);
        return list;
    }


}