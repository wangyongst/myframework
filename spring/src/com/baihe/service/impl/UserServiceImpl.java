package com.baihe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baihe.base.BaseMapper;
import com.baihe.base.BaseServiceImpl;
import com.baihe.dao.UserMapper;
import com.baihe.pojo.User;
import com.baihe.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Autowired
	private UserMapper userMapper;

	public String login(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		List<User> userList = new ArrayList();
		try {
			userList = userMapper.findAnd(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userList.size() == 0) {
			return "用户名或密码错误！";
		} else if (userList.size() > 1) {
			return "有多个相同用户，请联系管理员！";
		} else
			return "ok";
	}

	public boolean checkResult(String result) {
		if (result.equals("登陆成功！")) {
			return true;
		}
		return false;
	}

	@Override
	public BaseMapper<User> getMapper() {
		return this.getMapper();
	}
}
