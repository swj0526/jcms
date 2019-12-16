package com.jczx.controller;

import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 孙文举
 * 基础的controller,所有的controller都继承,去调用里面的基础方法
 */
public class BaseController<T> {
    @Autowired
    private HttpServletRequest request;

    /**
     * @param limit 当前页面显示的条数
     * @param page  显示的当前页
     * @return
     */
    public Pager checkPager(int limit, int page) {
        Pager pager = new Pager();
        pager.setCurrentPage(page);
        pager.setPageSize(limit);
        return pager;
    }

    public ServiceResult layuiList(List<T> list, Pager pager) {
        ServiceResult serviceResult = new ServiceResult(true, list, "", pager);
        return serviceResult;
    }

    public Map<String, Object> uploadeResult(ServiceResult serviceResult) {
        Map<String, Object> map = new HashMap<>();
        if (serviceResult.isSuccess() == true) {
            map.put("code", 0);
            map.put("result", serviceResult.getResult());
        } else {
            map.put("code", -1);
            map.put("msg", serviceResult.getMsg());
        }
        return map;
    }

    /**
     * 获取项目的根路径
     *
     * @return
     */
    public String getPath() {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        int i = path.lastIndexOf("/classes");
        String substring = path.substring(0, i);
        return substring;

    }

    /**
     * 获取上传文章存放的文件路径
     */
    public String getArticlePath() {
        return getPath() + "/upload/article/";
    }

    /**
     * 获取上传excel存放的文件路径
     */
    public String getExcelPath() {
        return getPath() + "/upload/excel/";
    }

    /**
     * 获取上传单据存放的文件路径
     */
    public String getImgPath() {
        return getPath() + "/upload/img/";
    }

    /**
     * 获取学生上传文件的路径
     */
    public String getStudentPath() {
        return getPath() + "/upload/studentFile/";
    }

    /**
     * 获取老师上传文件的路径
     */
    public String getTeacherPath() {
        return getPath() + "/upload/teacherFile/";
    }

}
