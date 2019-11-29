package com.jczx.service;

import com.jczx.domain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 于振华
 * @create 2019-11-28 13:06
 */
@Component
public class StudentService extends BaseService{
    /**
     * @author 丛枭钰
     * @create 2019-11-28 13:06
     */
    public TbStudent get(String student){
        Conditions conditions=new Conditions(getTableName());
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        TbStudent one = getOne(conditions);
        return one;
    }

    /**
     * 于振华
     * 查询所在班级
     *
     * @param majorId
     * @return
     */
  public List<TbStudent> checkMajor(Integer majorId){
      Conditions conditions = getConditins();
      conditions.putEW("majorId",majorId);
     return getList(conditions);
  }

    /**
     * 于振华
     * 查询渠道
     *
     * @param channelId
     * @return
     */
    public List<TbStudent> checkChannel(Integer channelId) {
        Conditions conditions = getConditins();
        conditions.putEW("channelId", channelId);
        return getList(conditions);
    }

    public List<TbStudent> listStudent(TbStudent student) {
        Conditions conditions = getConditins();
        if (student.getState() == TbStudent.STATE_ENTRANCE) {
            List<TbStudent> list = getList(conditions);
            return list;
        }
        return null;
    }

    /**
     * 查询当前学生信息
     *
     * @param id
     * @return
     */
    public TbStudent getStudent(Integer id) {
        return getById(getTableName(), id);
    }

    public InputStream studentExcel(String keywords, String createTime, String labelIds, String sex, Pager pager) {
        ExcelDatas excelDatas = new ExcelDatas();
        List<TbStudent> list = recruitService.listRecruit(keywords, createTime, labelIds, sex, pager);//调用查询信息
        excelDatas.addStringArray(0, 0, new String[]{"姓名", "性别", "意向", "出生年月", "学校", "手机号", "QQ号", "微信", "渠道"});
        excelDatas.addObjectList(1, 0, list, new String[]{"name", "sex", "labelIds", "birthDate", "school", "studentPhone", "qq", "weChat", "channelId"});
        InputStream inputStream = ExcelUtil.exportExcel(excelDatas);
        return inputStream;
    }


    @Override
    public String getTableName() {
        return TbStudent.class.getSimpleName();
    }
}
