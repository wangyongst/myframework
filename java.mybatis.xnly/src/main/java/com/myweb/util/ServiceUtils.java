package com.myweb.util;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by BHWL on 2016-11-30.
 */
public class ServiceUtils {

    //status说明
    //0，未选择
    //1，正确结果
    //2，系统异常
    //3，选择了多条记录
    //4，保存条件己存在
    //5, 必须值不能为空
    //6, 查询结果为空

    public static boolean isOnlyOneId(Result result, String id) {
        if (isIds(result, id)) {
            TreeSet<String> set = (TreeSet<String>) result.getData();
            if (set.size() < 1) {
                result.setStatus(0);
                result.setMessage("请先至少选择一条记录！");
            } else if (set.size() > 1) {
                result.setStatus(3);
                result.setMessage("本操作只可选择一条记录，您选择了多条记录！");
            } else {
                result.setData(Integer.parseInt(set.first()));
                return true;
            }
        }
        return false;
    }


    public static boolean isBlankValue(Result result, String value) {
        if (StringUtils.isBlank(value)) {
            result.setStatus(5);
            result.setMessage("必须值不能为空！请重新填写表单的必须项！");
            return true;
        }
        return false;
    }

    public static boolean isNotUnique(Result result, int size, String crud) {
        if (size > 0) {
            if (size == 1 && StringUtils.isNotBlank(crud) && crud.equals("update")) {
                return false;
            }
            result.setStatus(4);
            result.setMessage("必须值不唯一！请重新填写表单的必须项！");
            return true;
        }
        return false;
    }

    public static boolean isIds(Result result, String id) {
        if (StringUtils.isBlank(id)) {
            result.setStatus(0);
            result.setMessage("请先至少选择一条记录！");
        } else {
            TreeSet<String> treeSet = new TreeSet<String>(Arrays.asList(id.split(",")));
            treeSet.remove("");
            result.setData(treeSet);
            return true;
        }
        return false;
    }

    public static Result isCRUDOK(String crud, Result result, int count) {
        if (crud.equals("delete")) {
            isDeleteOK(result, count);
        } else if (crud.equals("update")) {
            isUpdateOK(result, count);
        } else if (crud.equals("create")) {
            isCreateOK(result, count);
        }
        return result;
    }


    public static boolean isUpdateOK(Result result, int count) {
        if (count != 0) {
            result.setMessage("您修改/更新了" + NumberFormatUtils.formatInteger(count) + "条记录");
        } else {
            return isNotOK(result);
        }
        return true;
    }

    public static boolean isCreateOK(Result result, int count) {
        if (count != 0) {
            result.setMessage("您添加/创建了" + NumberFormatUtils.formatInteger(count) + "条记录");
        } else {
            return isNotOK(result);
        }
        return true;
    }

    public static boolean isDeleteOK(Result result, int count) {
        if (count != 0) {
            result.setMessage("您删除了" + NumberFormatUtils.formatInteger(count) + "条记录");
        } else {
            return isNotOK(result);
        }
        return true;
    }


    public static boolean isReseachOK(Result result, Object object) {
        if (object == null) {
            return isNotOK(result);
        } else {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                try {
                    if (f.getName().equals("id") && (Integer) f.get(object) == 0) { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                        result.setStatus(6);
                        result.setMessage("没有查询到相关记录，请重试！");
                        return true;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return isNotOK(result);
                }
            }
            result.setData(object);
        }
        return true;
    }

    public static boolean isNotOK(Result result) {
        result.setStatus(2);
        result.setMessage("操作失败，请检查您的输入，如有问题请联系管理员,Email:331527770@qq.com！");
        return true;
    }
}
