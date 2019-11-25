package com.jczx.service;

import com.jczx.domain.TbStudent;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

/**
 * 招生
 *
 * @author 于振华
 * @create 2019-11-21 19:38
 */
@Component
public class RecruitService extends Service {
    /**
     * 添加
     * @param student
     * @return
     */
    public ServiceResult addRecruit(TbStudent student) {
        add(student);
        return SUCCESS;
    }

    /**
     * 修改
     * @param student
     * @return
     */
   public ServiceResult modifyRecruit(TbStudent student){
        modify(student);
        return SUCCESS;
   }

}
