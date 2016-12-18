package com.myweb.service.xnly;

import com.myweb.pojo.mybatis.Menu;
import com.myweb.pojo.mybatis.Shuxing;
import com.myweb.pojo.mybatis.User;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface FrameworkService {

    Result login(HttpSession session, User user);

    Result logout(HttpSession session);

    Result getMenus(HttpSession session,Menu menu);

    Map<String, Object> getMyHome(HttpSession session, Map<String, Object> map);

    Map<String, Object> getUserMenuMap(HttpSession session, Map<String, Object> map);

    Map<String, Object> getColumnsNameMap(HttpSession session, Map<String, Object> map, String tableName, String columns, boolean notTable);

    Map<String, Object> getTitleMap(HttpSession session, Map<String, Object> map, String title, String tableTitle);

    Result getShuxings(HttpSession session, String name);

    Result getTableinfos(HttpSession session, String tableName, boolean notTable);

}
