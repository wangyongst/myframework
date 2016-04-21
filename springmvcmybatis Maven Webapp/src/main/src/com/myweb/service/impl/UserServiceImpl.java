package com.myweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.dao.User;
import com.myweb.dao.UserExample;
import com.myweb.dao.UserMapper;
import com.myweb.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public String login(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(example);
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
}
