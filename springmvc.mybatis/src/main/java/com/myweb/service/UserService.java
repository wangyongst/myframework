package com.myweb.service;

import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.Menu;
import com.myweb.vo.mybatis.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
	
	public JsonResult login(String username, String password, HttpSession session);

	public List<Menu> getMyMenus(User user, int parent);

}
