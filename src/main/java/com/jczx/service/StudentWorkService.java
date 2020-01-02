package com.jczx.service;

import com.jczx.domain.TbStudentWork;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-12-20 10:55
 */
@Component
public class StudentWorkService extends BaseService{
    @Autowired
    private AttachmentService attachmentService;

    public List<TbStudentWork> listWork(Integer homeWorkId){
        Conditions conditions = getConditions();
        conditions.putEW("homeworkId",homeWorkId);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        List<TbStudentWork> list = getList(conditions);
        for (int a=0;a<list.size();++a){
            list.get(a).setList(attachmentService.listWork(list.get(a).getId(),list.get(a).getStudentId()));
        }
        return list;
    }
    public ServiceResult modifyScore(Integer id, Integer studentId, Integer score){
        Conditions conditions = getConditions();
        conditions.putEW("id",id);
        conditions.putEW("studentId",studentId);
        modifyWithColumn(conditions,new Serializable[]{"score",score});
        return SUCCESS;
    }
    public ServiceResult modifyEstimateContent(Integer id, Integer studentId, String estimateContent){
        Conditions conditions = getConditions();
        conditions.putEW("id",id);
        conditions.putEW("studentId",studentId);
        modifyWithColumn(conditions,new Serializable[]{"estimateContent",estimateContent});
        return SUCCESS;
    }

    @Override
    public String getTableName() {
        return TbStudentWork.class.getSimpleName();
    }
}
