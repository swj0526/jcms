package com.jczx.service;

import com.jczx.domain.TbRecruitDetail;
import com.jczx.system.SC;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 于振华
 * @create 2019-11-25 23:48
 */
@Component
public class DetailService extends BaseService {
    @Override
    public String getTableName() {
        return TbRecruitDetail.class.getSimpleName();
    }
    /**
     * 添加详情
     * @param recruitDetail
     * @return
     */
    public ServiceResult addDetail(TbRecruitDetail recruitDetail) {
            recruitDetail.setCreateTime(SC.getNowDate());//操作时间
            recruitDetail.setOperatorId(SC.getOperatorId());//操作人
            add(recruitDetail);
        return SUCCESS;

    }

    /**
     * 查询详情
     * @param
     * @return
     */
    public List<TbRecruitDetail> listDetail(Integer studentId){
        Conditions conditions =getConditions();
        conditions.putEWIfOk("studentId",studentId);
        List<TbRecruitDetail> list = getList(conditions);
        return list;

    }

    /**
     * 查询当前学生的跟踪详情
     * @param id
     * @return
     */
    public TbRecruitDetail getDetail(Integer id){
        return getById(id);
    }
    /**
     * 删除
     */
    public ServiceResult delDetail (TbRecruitDetail recruitDetail){
        del(recruitDetail);
        return SUCCESS;
    }

    /**
     * 修改学生跟踪详情
     * @param recruitDetail
     * @return
     */
    public ServiceResult modifyDetail(TbRecruitDetail recruitDetail){
         modify(recruitDetail);
         return SUCCESS;

    }





}
