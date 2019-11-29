package com.jczx.service;

import com.jczx.domain.TbArticle;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

/**
 * 文章
 * @author 宋家新
 * @create 2019-11-28 18:53
 */
@Component
public class ArticleService  extends Service {
    public ServiceResult addArticle(TbArticle tbArticle){
        add(tbArticle);
        return SUCCESS;
    }

}
