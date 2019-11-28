package com.jczx.service;

import com.jczx.domain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import org.springframework.stereotype.Component;

/**
 * @author 丛枭钰
 * @create 2019-11-28 13:06
 */
@Component
public class StudentService extends BaseService{

    public TbStudent get(String name){
        Conditions conditions=new Conditions(getTableName());
        conditions.putEW("name",name);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
        TbStudent one = getOne(conditions);
        return one;
    }


    @Override
    public String getTableName() {
        return TbStudent.class.getSimpleName();
    }
}
