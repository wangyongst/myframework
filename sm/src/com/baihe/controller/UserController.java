package com.baihe.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.baihe.pojo.User;
import com.baihe.service.UserService;

public class UserController extends MultiActionController {
	private UserService userService;

	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String isLogin = userService.login(request.getParameter("username"),
				request.getParameter("password"));
		MappingJackson2JsonView json = new MappingJackson2JsonView();
		Map attributes = new HashMap();
		attributes.put("message", isLogin);
		json.setAttributesMap(attributes);
		mav.setView(json);
		return mav;
	}

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
		} else {
			mav.setViewName("home");
		}
		return mav;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
