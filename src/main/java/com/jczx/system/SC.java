package com.jczx.system;

import com.jczx.domain.TbRole;
import com.jczx.domain.TbUser;
import com.jczx.service.RoleService;
import com.jczx.service.UserService;
import net.atomarrow.services.Service;
import net.atomarrow.util.DateUtil;
import net.atomarrow.util.SpringContextUtil;
import net.atomarrow.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 孙文举
 * @description sessionController 里面放一些项目共用数据
 * @create 2019-11-22 14:02
 */
@Component
public class SC {
    private static Service getRoleService() {
        return SpringContextUtil.getBean(RoleService.class);
    }

    public static Date getNowDate() {
        return DateUtil.getNowDate();

    }

    public static int getOperatorId() {
        //#ToDo 孙文举 从session中获取登录用户的id.
        return 1;
    }

    public static HashSet getFunctionIds(HttpServletRequest request) {
        HttpSession session = request.getSession();
        TbUser user = (TbUser) request.getSession().getAttribute("user");
        String roleIds = user.getRoleIds();
        if(StringUtil.isBlank(roleIds)){
            return null;
        }
        Set<Integer> list = new HashSet<>();
        Set<Integer> functionList = new HashSet<>();
        String[] split = roleIds.split(",");
        for (int i = 1; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        for (Integer roleId : list) {
            TbRole role = getRoleService().getById(TbRole.class.getSimpleName(), roleId);
            String functionIds = role.getFunctionIds();
            if (functionIds != null) {
                String[] splitFunction = functionIds.split(",");
                for (int i = 1; i < splitFunction.length; i++) {
                    functionList.add(Integer.parseInt(splitFunction[i]));

                }
            }
        }
        return (HashSet) functionList;
    }
}