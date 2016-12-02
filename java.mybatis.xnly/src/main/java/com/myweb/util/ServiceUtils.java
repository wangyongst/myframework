package com.myweb.util;

import com.myweb.vo.Result;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;

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

    public static boolean isOnlyOne(Result result,String ids){
        if (StringUtils.isBlank(ids)) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length != 2) {
                result.setStatus(3);
                result.setMessage("您选择了多条记录，请选择一条记录！");
            } else {
               result.setStatus(1);
               return true;
            }
        }
        return false;
    }
}
