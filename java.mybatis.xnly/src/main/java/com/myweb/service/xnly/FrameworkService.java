package com.myweb.service.xnly;

import com.myweb.pojo.mybatis.Shuxing;
import com.myweb.pojo.mybatis.User;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface FrameworkService {

    public Result login(HttpSession session, User user);

    public Result logout(HttpSession session);

    public Map<String, Object> getMyMenus(HttpSession session);

    public Map<String, Object> getMyHome(HttpSession session, Map<String, Object> map);

    public Map<String, Object> getUserMenuMap(HttpSession session, Map<String, Object> map);

    public Map<String, Object> getColumnsNameMap(HttpSession session, Map<String, Object> map, String tableName, String columns, boolean notTable);

    public Map<String, Object> getTitleMap(HttpSession session, Map<String, Object> map,String title, String tableTitle);

    public Map<String, Object> getColumnsShuxingMap(HttpSession session, Map<String, Object> map, String columnName,String name);

    public Result getShuxing(HttpSession session, String name);

    public Result getTableinfo(HttpSession session, String tableName, boolean notTable);

}
