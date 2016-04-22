package com.myweb.service;

import javax.servlet.http.HttpSession;

import com.myweb.vo.JsonResult;

public interface UserService {
	
	public JsonResult login(String username,String password,HttpSession session);

}
