package com.jczx.service;

import com.jczx.domain.TbInternship;
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
        return TbInternship.class.getSimpleName();
    }

    /**
     * 编辑开始,结束时间
     *
     * @param
     * @param startTime
     * @param endTime
     * @return
     */
    public ServiceResult modifyInternship(Integer studentId, String startTime, String endTime) {
        Conditions conditions = getConditions();
        conditions.putEW("studentId", studentId);
        modifyWithColumn(conditions, new Serializable[]{"startDate", startTime, "endDate", endTime});
        return SUCCESS;
    }

    /**
     * 删除试学信息
     *
     * @param
     * @return
     */
    public ServiceResult deleteInternship(TbInternship internship) {
        Conditions conditions = getConditions();
        conditions.putEW("studentId", internship.getStudentId());
        delByBatch(conditions);
        return SUCCESS;
    }

    /**
     * 添加试学信息
     *
     * @param internship
     * @return
     */
    public ServiceResult addInternship(TbInternship internship) {
        add(internship);
        return SUCCESS;
    }

    /**
     * 查询试听学生信息
     *
     * @param pager
     * @return
     */
    public List<TbInternship> listInternship(String keywords, String searchTime, Integer timeState, Pager pager) {
        Conditions conditions = getConditions();
        if (timeState != null) {
            if (StringUtil.isNotBlank(searchTime)) {
                String[] split = searchTime.split(" - ");

                if (timeState == TbInternship.STATE_START_TIME) {
                    conditions.putBW("startDate", split[0], split[1]);
                }
                if (timeState == TbInternship.STATE_END_TIME) {
                    conditions.putBW("endDate", split[0], split[1]);
                }
            }
        }
        if (StringUtil.isNotBlank(keywords)){
            conditions.putLIKE("name",keywords);
        }
        List<TbInternship> listByPage = getListByPage(conditions, pager);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        return listByPage;
    }
}
