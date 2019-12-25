package com.jczx.service;

import com.jczx.domain.TbInternship;
import com.jczx.domain.TbStudent;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author 于振华
 * @create 2019-12-22 13:49
 */
@Component
public class InternshipService extends BaseService {

    @Override
    public String getTableName() {
        return TbStudent.class.getSimpleName();
    }

    /**
     * 查询试学
     * @param keywords
     * @param searchTime
     * @param pager
     * @return
     */
    public List<TbStudent> listInternship(String keywords, String searchTime, Integer timeState, Pager pager){
        Conditions conditions = getConditions();
        if (StringUtil.isNotBlank(keywords)) {
            conditions.parenthesesStart();
            conditions.putLIKE("name", keywords);
            conditions.or();
            conditions.putLIKE("studentPhone", keywords);
            conditions.parenthesesEnd();
        }
        conditions.putEWIfOk("entranceState", TbStudent.STATE_NOT_ENTRANCE);//试学
        if (pager == null) {
            List<TbStudent> list = getList(conditions);
            return list;
        }
        if (timeState!=null){
             String[] split = searchTime.split(" - ");
            if (timeState==1){
                conditions.putBW("startDate",split[0],split[1]);
            }
            if(timeState==0){
                conditions.putBW("endDate",split[0],split[1]);
            }
        }
        pager.setDataTotal(getCount(conditions));
        List<TbStudent> list = getListByPage(conditions, pager);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return list;
    }

    /**
     * 编辑开始,结束时间
     * @param id
     * @param startTime
     * @param endTime
     * @return
     */
    public ServiceResult modifyInternship(Integer id, String startTime, String endTime) {
        Conditions conditions = getConditions();
        conditions.putEW("id", id);
        modifyWithColumn(conditions, new Serializable[] {"startDate",startTime,"endDate",endTime});
        return SUCCESS;
    }

    /**
     * 删除试学信息
     * @param student
     * @return
     */
    public ServiceResult deleteInternship(TbStudent student){
        del(student);
        return SUCCESS;
    }

    /**
     *添加试学信息
     * @param internship
     * @return
     */
    public ServiceResult addInternship(TbInternship internship){
        add(internship);
        return SUCCESS;

    }
}
