package com.jczx.service;

import com.jczx.domain.TbTeacher;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
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
public class TeacherService  extends BaseService {

    /**
     * 添加老师
     * @param tbTeacher
     * @return
     */
    public ServiceResult addTeacher(TbTeacher tbTeacher) {
        Conditions conditions = new Conditions(getTableName());
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
        Conditions conditions = new Conditions(getTableName());
        conditions.putEW("phone",tbTeacher.getPhone());
        List<TbTeacher> list=getList(conditions);
        int id=0;
        for (int i=0;i<list.size();i++){
            id=list.get(i).getId();
        }
        System.out.println("前台传的id="+tbTeacher.getId());
        System.out.println("查询的id="+id);
        if (id!=tbTeacher.getId()&&list.size()!=0){
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
    public List<TbTeacher> teacherList(String keyword,Boolean hasQuit,Pager pager){
        Conditions conditions = new Conditions(getTableName());
        if (StringUtil.isNotBlank(keyword)){
            conditions.parenthesesStart();
            conditions.putLIKE("name",keyword);
            conditions.or();
            conditions.putLIKE("phone",keyword);
            conditions.parenthesesEnd();
        }
        if(hasQuit!=null){
            conditions.putEW("hasQuit",hasQuit);
        }
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
    public InputStream teacherExcel(String name,Boolean hasQuit, Pager pager) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbTeacher> list = teacherList(name,hasQuit,pager);
        excelDatas.addStringArray(0, 0, new String[]{"姓名","性别", "手机号", "是否在职"});
        excelDatas.addObjectList(1, 0, list, new String[]{"name", "gender", "phone", "quit"});//行,列,集合
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }

    /**
     * 下载模板
     * @return
     */
    public InputStream excel(){
        ExcelDatas excelDatas=new ExcelDatas();
        excelDatas.addStringArray(0, 0, new String[]{"id","姓名","性别", "手机号", "是否在职"});
        InputStream inputStream =ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }

    @Override
    public String getTableName() {
        return TbTeacher.class.getSimpleName();
    }

}
