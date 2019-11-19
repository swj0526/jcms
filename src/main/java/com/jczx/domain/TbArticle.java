package com.jczx.domain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

/**
 * @author 宋家新
 * @create 2019-11-18 21:11
 * 发文
 */
@Component
public class TbArticle  extends Domain {
    private Integer id;
    private String title;//标题
    private String receiver;//接收人
    private String type;//类型
    private String publisher;//发布人
    private String content;//内容
    private String releaseTime;//发布时间
    private String number;//查看人数


}
