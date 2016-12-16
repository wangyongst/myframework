package com.myweb.util;

import org.apache.commons.lang3.StringUtils;

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

    public static boolean isLegalIds(Result result,String ids){
        if (StringUtils.isBlank(ids)) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length != 2) {
                result.setStatus(3);
                result.setMessage("您选择了多条记录，请选择一条记录！");
            } else {
               return true;
            }
        }
        return false;
    }

    public static boolean isPutOK(Result result,int count){
            result.setStatus(0);
            result.setMessage("您修改了" + count + "条记录");
        return true;
    }

    public static boolean isPostOK(Result result,int count){
        result.setStatus(0);
        result.setMessage("您添加了" + count + "条记录");
        return true;
    }

    public static boolean isDeleteOK(Result result,int count){
        result.setStatus(0);
        result.setMessage("您删除了" + count + "条记录");
        return true;
    }
}
