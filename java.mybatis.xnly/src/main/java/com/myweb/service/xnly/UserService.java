package com.myweb.service.xnly;

import com.myweb.vo.Result;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
	
	public Result login(String username, String password, HttpSession session);

	public Result logout(HttpSession session);

	public Map<String,Object> getMyMenus(HttpSession session);

	public Map<String,Object> getUserMap(Map<String,Object> map,HttpSession session);

	public Map<String, Object> getColumnsNameMap(String tableName, Map<String, Object> map, HttpSession session,String columns);

}
