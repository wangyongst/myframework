package com.baihe.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.baihe.pojo.User;
import com.baihe.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		String isLogin = userService.login(username,password);
		MappingJackson2JsonView json = new MappingJackson2JsonView();
		Map attributes = new HashMap();
		attributes.put("message", isLogin);
		json.setAttributesMap(attributes);
		mav.setView(json);
		return mav;
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ModelAndView getAllUsers(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		List<User> userList = null;
		try {
			userList = userService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MappingJackson2JsonView json = new MappingJackson2JsonView();
		Map attributes = new HashMap();
		if (userList.size() > 0) {
			attributes.put("success", Boolean.TRUE);
			attributes.put("message", userList);

		} else {
			attributes.put("success", Boolean.FALSE);
			attributes.put("message", "用户列表不存在！");
		}
		json.setAttributesMap(attributes);
		mav.setView(json);
		return mav;
	}

	@RequestMapping(value = "/checkResult", method = RequestMethod.POST)
	public ModelAndView checkResult(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String result = null;
		try {
			result = new String(request.getParameter("result").getBytes(
					"iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		boolean isLogin = userService.checkResult(result);
		if (isLogin) {
			mav.setViewName("userList");
		}
		return mav;
	}
}
