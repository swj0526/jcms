package com.jczx.service;

import com.jczx.controller.HomeworkController;
import net.atomarrow.bean.ServiceResult;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

        if (file.isEmpty()) {
            return error("上传失败,请选择文件");
        }
        String fileName = file.getOriginalFilename();//获取文件名称


        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs(); //如果文件不存在,则创建文件夹
            return error("上传失败,请选择文件");
        }
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
           return SUCCESS;
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
       return SUCCESS;
    }


}