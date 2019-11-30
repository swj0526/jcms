package com.jczx.service;

import com.jczx.domain.TbArticle;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章
 *
 * @author 宋家新
 * @create 2019-11-28 18:53
 */
@Component
public class ArticleService extends BaseService {
    /**
     * 发布文章
     *
     * @param tbArticle
     * @return
     */
    public ServiceResult addArticle(TbArticle tbArticle) {
        add(tbArticle);
        return SUCCESS;
    }

    /**
     * 查询文章列表
     *
     * @param keyword
     * @param state
     * @param pager
     * @return
     */
    public List<TbArticle> articleList(String keyword, Integer state, Pager pager) {
        Conditions conditions = new Conditions(getTableName());
        if (StringUtil.isNotBlank(keyword)) {
            conditions.parenthesesStart();
            conditions.putLIKE("name", keyword);
            conditions.or();
            conditions.putLIKE("phone", keyword);
            conditions.parenthesesEnd();
        }
        conditions.putEWIfOk("", state);
        pager.setDataTotal(getCount(conditions));
        List<TbArticle> article = getListByPage(conditions, pager);
        return article;
    }

    /**
     * 修改状态
     * @param tbArticle
     * @return
     */
    public ServiceResult articleModify(TbArticle tbArticle) {
        modify(tbArticle);
        return SUCCESS;
    }


    public List<TbArticle> checkType(Integer typeId) {
        Conditions conditins = getConditions();
        conditins.putEW("typeId", typeId);
        return getList(conditins);

    }

    @Override
    public String getTableName() {
        return TbArticle.class.getSimpleName();
    }
}
