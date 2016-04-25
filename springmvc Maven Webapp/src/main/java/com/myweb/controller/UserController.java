package com.myweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.myweb.service.UserService;
import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.User;

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
