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
     *查询所在班级
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
     * @param channelId
     * @return
     */
    public List<TbStudent> checkChannel(Integer channelId){
        Conditions conditions = getConditins();
        conditions.putEW("channelId",channelId);
        return getList(conditions);
    }




    @Override
    public String getTableName() {
        return TbStudent.class.getSimpleName();
    }
}
