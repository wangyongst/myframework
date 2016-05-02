package com.myweb.service;

import com.myweb.vo.Result;
import com.myweb.vo.mybatis.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserService {
	
	public Result login(String username, String password, HttpSession session);

	public Map<String,Object> getMyMenus(HttpSession session);

	public Map<String,Object> getUserMap(Map<String,Object> map,HttpSession session);

	public Map<String,Object> getColumnsNameMap(String tableName,Map<String,Object> map,HttpSession session);

}
