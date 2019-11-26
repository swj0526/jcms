package com.jczx.service;

import com.jczx.domain.TbTeacher;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import net.atomarrow.util.StringUtil;
import net.atomarrow.util.excel.ExcelDatas;
import net.atomarrow.util.excel.ExcelUtil;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * 老师
 * @author 宋家新
 * @create 2019-11-21 13:30
 */
@Component
public class TeacherService  extends Service {
    Conditions conditions = new Conditions(TbTeacher.class);
    /**
     * 添加老师
     * @param tbTeacher
     * @return
     */
    public ServiceResult addTeacher(TbTeacher tbTeacher) {
        conditions.putEW("phone",tbTeacher.getPhone());
        List<TbTeacher> list = getList(conditions);
        if (list.size()!=0){
            return error("手机号重复");
        }
        if(StringUtil.isBlank(tbTeacher.getName())||StringUtil.isBlank(tbTeacher.getPhone())){
            return error("请输入姓名和手机号");
        }

        add(tbTeacher);
        return SUCCESS;
    }

    /**
     * 修改老师信息
     * @param tbTeacher
     * @return
     */
    public ServiceResult modifyTeacher(TbTeacher tbTeacher){
        conditions.putEW("phone",tbTeacher.getPhone());
        List<TbTeacher> list = getList(conditions);
        if (list.size()!=0){
            return error("手机号重复");
        }
        if(StringUtil.isBlank(tbTeacher.getName())||StringUtil.isBlank(tbTeacher.getPhone())){
            return error("请输入姓名和手机号");
        }
        modify(tbTeacher);
        return SUCCESS;
    }

    /**
     * 查找老师表所有信息
     * @return
     */
    public List<TbTeacher> teacherList(String name,boolean hasQuit,Pager pager){
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
     * 导出
     * @param name
     * @param hasQuit
     * @param pager
     * @return
     */
    public InputStream teacherExcel(String name,boolean hasQuit, Pager pager) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbTeacher> list = teacherList(name,hasQuit,pager);
        excelDatas.addStringArray(0, 0, new String[]{"id","姓名","性别", "手机号", "是否在职"});
        excelDatas.addObjectList(1, 0, list, new String[]{"id","name", "gender", "phone", "hasQuit"});//行,列,集合
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;

    }

}
