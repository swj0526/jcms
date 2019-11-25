package com.jczx.service;

import com.jczx.domain.TbTeacher;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 老师
 * @author 宋家新
 * @create 2019-11-21 13:30
 */
@Component
public class TeacherService  extends Service {
    /**
     * 添加老师
     * @param teacher
     * @return
     */
    public ServiceResult addTeacher(TbTeacher teacher) {
        add(teacher);
        return SUCCESS;
    }

    /**
     * 修改老师信息
     * @param teacher
     * @return
     */
    public ServiceResult modifyTeacher(TbTeacher teacher){
        modify(teacher);
        return SUCCESS;
    }

    /**
     * 查找老师表所有信息
     * @return
     */
    public List<TbTeacher> teacherList(String name,boolean hasQuit,Pager pager){
        Conditions conditions = new Conditions(TbTeacher.class);
        conditions.putEWIfOk("name",name);
        conditions.putEWIfOk("hasQuit",hasQuit);
        pager.setDataTotal(getCount(conditions));//调用分页之前给设置总条数
        List<TbTeacher> teacher = getListByPage(conditions,pager);
        return teacher;
    }

    /**
     * 删除
     * @param teacher
     * @return
     */
    public ServiceResult deleteTeacher(TbTeacher teacher){
        del(teacher);
        return SUCCESS;
    }

    /**
     * 导出excel
     * @param bean
     * @param pageBean
     * @return
     */
    /*public InputStream teacherExcel(TbTeacher bean, PageBean pageBean) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbTeacher> list = teacherList(bean,pageBean);
        excelDatas.addStringArray(0, 0, new String[]{"id","姓名","性别", "手机号", "是否在职"});
        excelDatas.addObjectList(1, 0, list, new String[]{"id","name", "gender", "phone", "hasQuit"});//行,列,集合
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;

    }*/

}
