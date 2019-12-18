package com.jczx.service;

import com.jczx.domain.TbArticle;
import com.jczx.system.SC;
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
     * @param article
     * @return
     */
    public ServiceResult addArticle(TbArticle article) {
        article.setCreateTime(SC.getNowDate());
        article.setOperatorId(SC.getOperatorId());
        add(article);
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
    public List<TbArticle> articleList(String keyword,Integer typeId,Integer state,String time,Pager pager) {
        Conditions conditions = getConditions();
        if (StringUtil.isNotBlank(keyword)) {
            conditions.parenthesesStart();
            conditions.putLIKE("title", keyword);
            conditions.or();
            conditions.putLIKE("receiverRoleIds", keyword);
            conditions.parenthesesEnd();
        }
        conditions.putEWIfOk("typeId",typeId);
        conditions.putEWIfOk("state", state);
        if (StringUtil.isNotBlank(time)) {
          String time1[]= time.split(" - ");
            conditions.putBW("createTime",time1[0],time1[1]);
        }
        pager.setDataTotal(getCount(conditions));
        List<TbArticle> articles = getListByPage(conditions, pager);
        return articles;
    }

    /**
     * 修改状态
     * @param article
     * @return
     */
    public ServiceResult articleModify(TbArticle article) {
        modify(article);
        return SUCCESS;
    }

    public List<TbArticle> checkType(Integer typeId) {
        Conditions conditions = getConditions();
        conditions.putEWIfOk("typeId", typeId);
        return getList(conditions);

    }

    @Override
    public String getTableName() {
        return TbArticle.class.getSimpleName();
    }
}
