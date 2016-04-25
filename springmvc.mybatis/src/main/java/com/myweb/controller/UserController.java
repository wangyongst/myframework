package com.myweb.controller;

import com.myweb.service.UserService;
import com.myweb.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	public UserService userService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public JsonResult login(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {
		return userService.login(username, password, session);
	}
}
