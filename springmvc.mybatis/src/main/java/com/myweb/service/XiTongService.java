package com.myweb.service;

import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.Renyuan;
import com.myweb.vo.mybatis.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface XiTongService {

	public List<User> getAllUsers(HttpSession session);

	public List<Renyuan> getAllRenyuans(HttpSession session);
}
