package com.myweb.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static boolean isOnlyOneId(Result result, String id) {
        if (StringUtils.isBlank(id)) {
            result.setStatus(0);
            result.setMessage("请先至少选择一条记录！");
        } else {
            String[] ida = id.split(",");
            if (ida.length != 2) {
                result.setStatus(3);
                result.setMessage("本操作只可选择一条记录，您选择了多条记录！");
            } else {
                result.setData(id.split(",")[1]);
                return true;
            }
        }
        return false;
    }

    public static boolean isIds(Result result, String id) {
        if (StringUtils.isBlank(id)) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            result.setData(Arrays.asList(id.split(",")));
            return true;
        }
        return false;
    }

    public static boolean isUpdateOK(Result result, int count) {
        if (count != 0) {
            result.setMessage("您修改了" + NumberFormatUtils.formatInteger(count) + "条记录");
        } else {
            result.setStatus(2);
            result.setMessage("操作失败，请检查您的输入，如有问题请联系管理员,Email:331527770@qq.com！");
            return false;
        }
        return true;
    }

    public static boolean isSaveOK(Result result, int count) {
        result.setMessage("您添加了" + count + "条记录");
        if (count != 0) {
            result.setMessage("您添加了" + NumberFormatUtils.formatInteger(count) + "条记录");
        } else {
            result.setStatus(2);
            result.setMessage("操作失败，请检查您的输入，如有问题请联系管理员,Email:331527770@qq.com！");
            return false;
        }
        return true;
    }

    public static boolean isDeleteOK(Result result, int count) {
        if (count != 0) {
            result.setMessage("您删除了" + NumberFormatUtils.formatInteger(count) + "条记录");
        } else {
            result.setStatus(2);
            result.setMessage("操作失败，请检查您的输入，如有问题请联系管理员,Email:331527770@qq.com！");
            return false;
        }
        return true;
    }
}
