package myweb.service;

import com.myweb.vo.JsonResult;

import javax.servlet.http.HttpSession;

public interface UserService {
	
	public JsonResult login(String username, String password, HttpSession session);

}
