package com.myweb.service;

import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.Menu;
import com.myweb.vo.mybatis.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
	
	public JsonResult login(String username, String password, HttpSession session);

	public Map<String,Object> getMyMenus(User user);

}
