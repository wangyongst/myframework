package com.baihe.service;


import com.baihe.base.BaseService;
import com.baihe.dao.UserDao;
import com.baihe.pojo.User;

public interface UserService extends BaseService<User> {
	
	public String login(String username,String password);
	
	public boolean checkResult(String result);
	
}
