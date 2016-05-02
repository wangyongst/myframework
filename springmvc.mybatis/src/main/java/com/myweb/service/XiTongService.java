package com.myweb.service;

import com.myweb.vo.Result;
import com.myweb.vo.mybatis.Renyuan;
import com.myweb.vo.mybatis.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface XiTongService {

	public List<User> getAllUsers(HttpSession session);

	public List<Renyuan> getAllRenyuans(HttpSession session);

	public Result getRenyuan(HttpSession session, String ids);

	public Result getUser(HttpSession session, String ids);

	public Result editRenyuan(HttpSession session, Renyuan renyuan);

	public Result editUser(HttpSession session, User user);

	public Result deleteRenyuan(HttpSession session, String ids);

	public Result deleteUser(HttpSession session, String ids);
}
