package com.jczx.service;

import com.jczx.controller.HomeworkController;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import net.atomarrow.util.RandomSn;
import net.atomarrow.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author 孙文举
 * @description baseservice.所有的service继承
 * @create 2019-11-22 8:41
 */
@Component
public abstract class BaseService extends Service {
    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkController.class);

    /**
     * 返回表名
     *
     * @return
     */
    public abstract String getTableName();

    /**
     * 返回conditons条件对象
     *
     * @return
     */
    protected Conditions getConditions() {
        return new Conditions(getTableName());
    }

    /**
     * 可在controller中直接使用,不用在二次封装
     *
     * @param id
     * @return
     */
    public <T> T getById(Integer id) {
        return getById(getTableName(), id);
    }

    /**
     * 共用上传方法
     *
     * @return
     */
    public ServiceResult upload(MultipartFile file, String filePath) {
        String allFile = "";
        if (file == null) {
            return error("上传失败,请选择文件");
        }
        Calendar now = Calendar.getInstance();//将文件名称改成秒数
        File dest = new File(filePath + now.getTimeInMillis()+ RandomSn.getSn(3));
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
               dest.mkdirs();
        }
        try {
            file.transferTo(dest);
            allFile =dest+""; //上传成功之后返回路径
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
            return error("上传失败!");
        }
        LOGGER.info("上传成功");
        return success(allFile);
    }


}