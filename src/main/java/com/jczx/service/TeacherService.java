package com.jczx.service;

import com.jczx.domain.TbTeacher;
import com.jczx.domain.TbUser;
import net.atomarrow.bean.Pager;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.util.StringUtil;
import net.atomarrow.util.excel.ExcelDatas;
import net.atomarrow.util.excel.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * 老师
 *
 * @author 宋家新
 * @create 2019-11-21 13:30
 */
@Component
public class TeacherService extends BaseService {
    @Autowired
    private UserService userService;




    /**
     * 添加老师
     *
     * @param teacher
     * @return
     */
    public ServiceResult addTeacher(TbTeacher teacher) {
        Conditions conditions = getConditions();
        conditions.putEW("phone", teacher.getPhone());
        List<TbTeacher> list = getList(conditions);
        if (list.size() != 0) {
            return error("手机号重复");
        }
        if (StringUtil.isBlank(teacher.getName()) || StringUtil.isBlank(teacher.getPhone())) {
            return error("请输入姓名和手机号");
        }
        add(teacher);
        userService.addTeacherUser(teacher);

        return SUCCESS;
    }

    /**
     * 修改老师信息
     *
     * @param teacher
     * @return
     */
    public ServiceResult modifyTeacher(TbTeacher teacher) {
        Conditions conditions = getConditions();
        conditions.putEW("phone", teacher.getPhone());
        List<TbTeacher> list = getList(conditions);
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            id = list.get(i).getId();
        }
        if (id != teacher.getId() && list.size() != 0) {
            return error("手机号重复");
        }
        if (StringUtil.isBlank(teacher.getName()) || StringUtil.isBlank(teacher.getPhone())) {
            return error("请输入姓名和手机号");
        }
        modify(teacher);
        userService.modifyUser(TbUser.TYPE_TEACHER,teacher.getName(),teacher.getPhone(),teacher.getId());
        //判断是否修改老师的状态,
        if (teacher.getHasQuit()) { //修改为在职
            TbUser user = userService.getUser(teacher.getId(), TbUser.TYPE_TEACHER);
            if(user==null){
                userService.addTeacherUser(teacher);
            }

        } else { //离职
            userService.deleteUser(teacher.getId(), TbUser.TYPE_TEACHER);
        }
        return SUCCESS;
    }

    /**
     * 查找老师表所有信息
     *
     * @return
     */
    public List<TbTeacher> teacherList(String keyword, Boolean hasQuit, Pager pager) {
        Conditions conditions = new Conditions(getTableName());
        if (StringUtil.isNotBlank(keyword)) {
            conditions.parenthesesStart();
            conditions.putLIKE("name", keyword);
            conditions.or();
            conditions.putLIKE("phone", keyword);
            conditions.parenthesesEnd();
        }
        if (hasQuit != null) {
            conditions.putEW("hasQuit", hasQuit);
        }
        pager.setDataTotal(8);//调用分页之前给设置总条数
        return getListByPage(conditions, pager);
    }

    /**
     * 删除
     *
     * @param teacher
     * @return
     */
    public ServiceResult deleteTeacher(TbTeacher teacher) {
        del(teacher);
        return SUCCESS;
    }

    /**
     * 导出
     *
     * @param name
     * @param hasQuit
     * @return
     */
    public InputStream teacherExcel(String name, Boolean hasQuit) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbTeacher> list = teacherList(name, hasQuit, null);
        excelDatas.addStringArray(0, 0, new String[]{"姓名", "性别", "手机号", "是否在职"});
        excelDatas.addObjectList(1, 0, list, new String[]{"name", "gender", "phone", "quit"});//行,列,集合
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }

    /**
     * 下载模板
     *
     * @return
     */
    public InputStream excel() {
        ExcelDatas excelDatas = new ExcelDatas();
        excelDatas.addStringArray(0, 0, new String[]{ "姓名", "性别", "手机号", "是否在职"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }

    @Override
    public String getTableName() {
        return TbTeacher.class.getSimpleName();
    }

}
