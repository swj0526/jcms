package com.jczx.service;

import com.jczx.domain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 丛枭钰
 * @create 2019-11-28 13:06
 */
@Component
public class StudentService extends BaseService{

    public TbStudent get(TbStudent student){
        Conditions conditions=new Conditions(getTableName());


        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        TbStudent one = getOne(conditions);
        return one;
    }

  public List<TbStudent> checkMajor(Integer majorId){
      Conditions conditions = getConditins();
      conditions.putEW("majorId",majorId);
     return getList(conditions);
  }

    @Override
    public String getTableName() {
        return TbStudent.class.getSimpleName();
    }
}
