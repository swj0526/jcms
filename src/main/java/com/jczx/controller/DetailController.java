package com.jczx.controller;

import com.jczx.domain.TbRecruitDetail;
import com.jczx.domain.TbStudent;
import com.jczx.service.DetailService;
import com.jczx.service.StudentService;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 详情
 *
 * @author 于振华
 * @create 2019-11-25 23:42
 */
@Controller
@RequestMapping("/details")
public class DetailController {
    @Autowired
    private DetailService detailService;
    @Autowired
    private StudentService studentService;

    /**
     * 添加
     * 跟踪详情
     *
     * @param recruitDetail
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServiceResult addDetail(TbRecruitDetail recruitDetail) {
        ServiceResult detailResult = detailService.addDetail(recruitDetail);
        return detailResult;
    }
    /**
     *
     * @param studentId
     * @return
     */

    /**
     * 招生信息详情
     *
     * @return
     */
    @RequestMapping("/todetail")
    public String upFollow(Integer id, Map<String, Object> map) {
        map.put("id",id);
        TbStudent student = studentService.getById(id);
        map.put("student",student);
        List<TbRecruitDetail> detail = detailService.listDetail(id);
        map.put("detail",detail);
        return "recruit/detailfollow";
    }
    /**
     * 删除跟进
     * @param
     * @return
     */
    @RequestMapping("/deletefollow")
    @ResponseBody
    public ServiceResult deleteFollow(TbRecruitDetail RecruitDetail){
        ServiceResult serviceResult = detailService.delDetail(RecruitDetail);
        return serviceResult;
    }

    /**
     * 携带数据到修改页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/tomodify")
    public String toModify(Integer id,Map<String,Object>map){
        TbRecruitDetail detail = detailService.getById(id);
        map.put("detail",detail);
        return "recruit/modfollowdata";
    }

    /**
     * 修改学生跟踪详情
     * @param recruitDetail
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ServiceResult modify(TbRecruitDetail recruitDetail){
        ServiceResult modifyDetail = detailService.modifyDetail(recruitDetail);
        return modifyDetail;


    }
}
