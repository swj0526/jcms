package com.jczx.service;

import com.jczx.domain.TbRecruitDetail;
import com.jczx.system.SC;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.services.Service;
import net.atomarrow.util.StringUtil;
import org.springframework.stereotype.Component;

/**
 * @author 于振华
 * @create 2019-11-25 23:48
 */
@Component
public class DetailService extends Service {
    public ServiceResult add(TbRecruitDetail recruitDetail) {
        if (StringUtil.isNotBlank(
                recruitDetail.getFollowTime().toString())
                && StringUtil.isNotBlank(recruitDetail.getLabelIds())
        ) {
            recruitDetail.setCreateTime(SC.getNowDate());//操作时间
            recruitDetail.setOperatorId(SC.getOperatorId());//操作人
            add(recruitDetail);
        }

        return SUCCESS;

    }
}
