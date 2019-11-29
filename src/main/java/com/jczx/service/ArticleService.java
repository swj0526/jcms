package com.jczx.service;

import com.jczx.domain.TbArticle;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
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
    public ServiceResult addArticle(TbArticle tbArticle) {
        add(tbArticle);
        return SUCCESS;
    }

    public List<TbArticle> checkType(Integer typeId) {
        Conditions conditins = getConditins();
        conditins.putEW("typeId", typeId);
        return getList(conditins);

    }

    @Override
    public String getTableName() {
        return null;
    }
}
