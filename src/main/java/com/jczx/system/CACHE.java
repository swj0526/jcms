package com.jczx.system;


import com.jczx.domain.TbDictionary;
import com.jczx.domain.TbMajor;
import com.jczx.domain.TbTeacher;
import com.jczx.service.DictionaryService;
import com.jczx.service.MajorService;
import com.jczx.service.TeacherService;
import net.atomarrow.services.Service;
import net.atomarrow.util.RandomSn;
import net.atomarrow.util.SpringContextUtil;
import net.atomarrow.util.StringUtil;


/**
 * @author 孙文举
 * @create 2019-11-11 15:08
 */

public class CACHE {
    /**
     * 现在使用的是集map实现类
     *
     * @return
     */
    private static CacheInterface getUtil() {
        return SpringContextUtil.getBean(MapUtil.class);
    }

    /**
     * 字典表的service,此处需要具体的service
     *
     * @return
     */
    private static Service getDictionaryService() {
        return SpringContextUtil.getBean(DictionaryService.class);
    }
    private static Service getMajorService() {
        return SpringContextUtil.getBean(MajorService.class);
    }
    private static Service getTeacherService() {
        return SpringContextUtil.getBean(TeacherService.class);
    }
    private static String PREFEX = RandomSn.getLowSn(3);

    /**
     * 获取key的名称
     *
     * @param tableName
     * @param id
     * @return
     */
    private static String getKey(String tableName, Integer id) {
        return PREFEX + tableName + id;
    }


    /**
     * 字典表对象
     *
     * @param id
     * @return
     */
    private static TbDictionary getDictionary(Integer id) {
        if (id == 0 || id == null) {
            return null;
        }
        TbDictionary dictionary = (TbDictionary) getUtil().get(getKey(TbDictionary.class.getSimpleName(), id));
        if (dictionary != null) {
            return dictionary;
        }
        TbDictionary dictionaryDB = getDictionaryService().getById(TbDictionary.class.getSimpleName(), id);
        if (dictionaryDB == null) {
            return null;
        }
        getUtil().set(getKey(TbDictionary.class.getSimpleName(), id), dictionaryDB);
        return dictionaryDB;
    }

    /**
     * 渠道的名称
     *
     * @param channelId
     * @return
     */
    public static String getChannelName(Integer channelId) {
        if (channelId == null || channelId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(channelId);
        if (dictionary == null) {
            return "";
        }
        return dictionary.getName();
    }

    /**
     * 缴费类型
     */
    public static String getTypeName(Integer typeId) {
        if (typeId == null || typeId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(typeId);
        if (dictionary == null) {
            return "";
        }
        return dictionary.getName();
    }

    /**
     * 缴费方式
     */
    public static String getPaymentMethodName(Integer paymentMethodId) {
        if (paymentMethodId == null || paymentMethodId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(paymentMethodId);
        if (dictionary == null) {
            return "";
        }
        return dictionary.getName();
    }

    /**
     * 学年
     *
     * @param semesterId
     * @return
     */
    public static String getSemesterName(Integer semesterId) {
        if (semesterId == null || semesterId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(semesterId);
        if (dictionary == null) {
            return "";
        }
        return dictionary.getName();
    }

    /**
     * 文章类型
     */
    public static String getArticleTypeName(Integer typeId) {
        if (typeId == null || typeId == 0) {
            return "";
        }
        TbDictionary dictionary = getDictionary(typeId);
        if (dictionary == null) {
            return "";
        }
        return dictionary.getName();
    }

    /**
     * 意向标签name数组
     */
    public static String getLabelNames(String labelIds) {
        if (StringUtil.isBlank(labelIds)) {
            return "";
        }
        String[] split = labelIds.split(",");
        String names = "";
        for (int i = 1; i < split.length; i++) {
            TbDictionary dictionary = getDictionary(Integer.valueOf(split[i]));
            if (dictionary != null) {
                if (i == split.length - 1) {
                    names = names + dictionary.getName();
                } else {
                    names = names + dictionary.getName() + ",";
                }

            }
        }
        return names;
    }
    /**
     * 专业-班级对象
     *
     * @param id
     * @return
     */
    private static TbMajor getMajor(Integer id) {
        if (id == 0 || id == null) {
            return null;
        }
        TbMajor major = (TbMajor) getUtil().get(getKey(TbMajor.class.getSimpleName(), id));
        if (major != null) {
            return major;
        }
        TbMajor majorDB = getMajorService().getById(TbMajor.class.getSimpleName(), id);
        if (majorDB == null) {
            return null;
        }
        getUtil().set(getKey(TbMajor.class.getSimpleName(), id), majorDB);
        return majorDB;
    }

    /**
     * 获取班级的名称
     * @param majorId
     * @return
     */
    public static String getMajorName(Integer majorId){
        if (majorId == null || majorId == 0) {
            return "";
        }
        TbMajor major = getMajor(majorId);
        if (major == null) {
            return "";
        }
        return major.getName();
    }
    /**
     * 老师对象
     *
     * @param id
     * @return
     */
    private static TbTeacher getTeacher(Integer id) {
        if (id == 0 || id == null) {
            return null;
        }
        TbTeacher teacher = (TbTeacher) getUtil().get(getKey(TbTeacher.class.getSimpleName(), id));
        if (teacher != null) {
            return teacher;
        }
        TbTeacher teacherDB = getTeacherService().getById(TbTeacher.class.getSimpleName(), id);
        if (teacherDB == null) {
            return null;
        }
        getUtil().set(getKey(TbTeacher.class.getSimpleName(), id), teacherDB);
        return teacherDB;
    }
    /**
     * 获取老师名字
     * @param teacherId
     * @return
     */
    public static String getTeacherName(Integer teacherId) {
        if (teacherId == null || teacherId == 0) {
            return "";
        }
        TbTeacher teacher = getTeacher(teacherId);
        if (teacher == null) {
            return "";
        }
        return teacher.getName();
    }

    /**
     * 修改删除的时候调用该方法,清空该缓存对象
     *
     * @param id
     */
    public static void remove(Integer id) {
        getUtil().remove(getKey(TbDictionary.class.getSimpleName(), id));
    }

    /**
     * 移除所有的数据
     */
    private static void removeAll() {
        getUtil().removeAll();
    }




















    /* *//**
     * 返回渠道的名称
     *
     * @param channelId
     * @return
     *//*
     */

    /*
     *//**
     * 缴费类型
     *
     * @param typeId
     * @return
     *//*
    public static String getTypeName(Integer typeId) {
        if (typeId == null || typeId == 0) {
            return "";
        }
        ValueOperations<String, String> valueOperations = getRedisTemplate().opsForValue();
        String typeName = valueOperations.get(getKey(TbDictionary.class.getSimpleName(), typeId));
        if (StringUtil.isNotBlank(typeName)) {
            return typeName;
        }
        TbDictionary dictionary = getDictionaryService().getById(TbDictionary.class, typeId);
        if (dictionary == null) {
            return "";
        }
        valueOperations.set(getKey(TbDictionary.class.getSimpleName(), typeId), dictionary.getName());
        System.out.println(dictionary.getName());
        return valueOperations.get(getKey(TbDictionary.class.getSimpleName(), typeId));
    }

    *//**
     * 缴费方式
     *
     * @param paymentMethodId
     * @return
     *//*
    public static String getPaymentMethodName(Integer paymentMethodId) {
        if (paymentMethodId == null || paymentMethodId == 0) {
            return "";
        }
        ValueOperations<String, String> valueOperations = getRedisTemplate().opsForValue();
        String methodeName = valueOperations.get(getKey(TbDictionary.class.getSimpleName(), paymentMethodId));
        if (StringUtil.isNotBlank(methodeName)) {
            return methodeName;
        }
        TbDictionary dictionary = getDictionaryService().getById(TbDictionary.class, paymentMethodId);
        if (dictionary == null) {
            return "";
        }
        valueOperations.set(getKey(TbDictionary.class.getSimpleName(), paymentMethodId), dictionary.getName());
        System.out.println(dictionary.getName());
        return valueOperations.get(getKey(TbDictionary.class.getSimpleName(), paymentMethodId));
    }

    public static String getSemesterName(Integer semesterId) {
        if (semesterId == null || semesterId == 0) {
            return "";
        }
        ValueOperations<String, String> valueOperations = getRedisTemplate().opsForValue();
        String semestereName = valueOperations.get(getKey(TbDictionary.class.getSimpleName(), semesterId));
        if (StringUtil.isNotBlank(semestereName)) {
            return semestereName;
        }
        TbDictionary dictionary = getDictionaryService().getById(TbDictionary.class, semesterId);
        if (dictionary == null) {
            return "";
        }
        valueOperations.set(getKey(TbDictionary.class.getSimpleName(), semesterId), dictionary.getName());
        System.out.println(dictionary.getName());
        return valueOperations.get(getKey(TbDictionary.class.getSimpleName(), semesterId));
    }*/
}
