package com.jczx.service;

import com.jczx.domain.TbDictionary;
import com.jczx.domain.TbMajor;
import com.jczx.system.SC;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 孙文举
 * @description
 * @create 2019-11-26 17:00
 */
@Component
public class MajorService extends BaseService {

    @Override
    public String getTableName() {
        return TbMajor.class.getSimpleName();
    }

    /**
     * 增加专业信息
     * @param major
     * @return
     */
    public ServiceResult addMajor(TbMajor major){
        if(StringUtil.isBlank(major.getName())){
            return error("");
        }
        major.setPid(0);
       major.setCreateTime(SC.getNowDate());
       major.setOperatorId(SC.getOperatorId());
       add(major);
       return SUCCESS;
    }
    /**
     * 增加班级信息
     * @param major
     * @return
     */
    public ServiceResult addClass(TbMajor major){
        if(major.getPid()==null||major.getPid()==0){
            return error("");
        }
        if(StringUtil.isBlank(major.getName())){
            return error("");
        }
        major.setName("∟"+major.getName());
        major.setPid(major.getPid());
        major.setCreateTime(SC.getNowDate());
        major.setOperatorId(SC.getOperatorId());
        add(major);
        return SUCCESS;
    }
    /**
     * 修改班级专业信息
     * @param major
     * @return
     */
    public ServiceResult modifyMajor(TbMajor major){
        TbMajor majorDB = getById(getTableName(), major.getId());
        if(majorDB==null){
            return error("");
        }
        if(StringUtil.isBlank(major.getName())){
            return error("");
        }
        modify(major);
        return SUCCESS;
    }

    /**
     * 返回班级-专业列表
     * @return
     */
    public List<TbMajor> listMajor(){
        Conditions conditions = new Conditions(getTableName());
        List<TbMajor> list = getList(conditions);
        return list;
    }
}