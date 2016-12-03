package com.myweb.service.xnly;

import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserService {

    public Result login(HttpSession session, String username, String password);

    public Result logout(HttpSession session);

    public Map<String, Object> getMyMenus(HttpSession session);

    public Map<String, Object> getMyHome(HttpSession session, Map<String, Object> map);

    public Map<String, Object> getUserMap(HttpSession session, Map<String, Object> map);

    public Map<String, Object> getColumnsNameMap(HttpSession session, Map<String, Object> map, String tableName, String columns, boolean isTable);

    public Map<String, Object> getTitleMap(HttpSession session, String title, String tableTitle);

    public Map<String, Object> getColumnsShuxingMap(HttpSession session, Map<String, Object> map, String columnName,String type);

}
