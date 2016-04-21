package com.baihe.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baihe.base.BaseDao;
import com.baihe.base.BaseServiceImpl;
import com.baihe.dao.UserDao;
import com.baihe.pojo.User;
import com.baihe.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	private UserDao userDao;

	public String login(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		List<User> userList = new ArrayList();
		try {
			userList = userDao.findAnd(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userList.size() == 0) {
			return "用户名或密码错误！";
		} else if (userList.size() > 1) {
			return "有多个相同用户，请联系管理员！";
		} else
			return "登陆成功！";
	}
	
	
	public boolean checkResult(String result) {
		if(result.equals("登陆成功！")){
			return true;
		}
		return false;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public BaseDao<User> getDao() {
			return this.getUserDao();
	}
}
