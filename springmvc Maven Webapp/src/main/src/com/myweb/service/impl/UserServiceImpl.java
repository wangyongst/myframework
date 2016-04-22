package com.myweb.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.dao.mybatis.UserMapper;
import com.myweb.service.UserService;
import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.User;
import com.myweb.vo.mybatis.UserExample;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public JsonResult login(String username, String password,
			HttpSession session) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username)
				.andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(example);
		JsonResult json = new JsonResult();
		if (userList.size() == 0) {
			json.setStatus(1);
			json.setMessage("用户名或密码错误！");
		} else if (userList.size() > 1) {
			json.setStatus(2);
			json.setMessage("有多个相同用户，请联系管理员！");
		} else {
			json.setStatus(0);
			session.setAttribute("user", userList.get(0));
			json.setMessage("登录成功！");
		}
		return json;
	}
}
