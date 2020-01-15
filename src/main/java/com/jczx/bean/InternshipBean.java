package com.jczx.bean;

import com.jczx.domain.TbStudent;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 于振华
 * @create 2019-12-29 9:16
 */
@Data
public class InternshipBean extends TbStudent {
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//试学开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//试学结束时间


}
