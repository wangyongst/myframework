package com.myweb.service;


import com.myweb.vo.Result;
import com.myweb.vo.mybatis.Laoren;
import com.myweb.vo.mybatis.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface XiTongService {

	public List<User> getAllUsers(HttpSession session);

	public List<Laoren> getAllLaorens(HttpSession session);

	public Result getLaoren(HttpSession session, String ids);

	public Result getUser(HttpSession session, String ids);

	public Result editLaoren(HttpSession session, Laoren laoren);

	public Result editUser(HttpSession session, User user);

	public Result deleteLaoren(HttpSession session, String ids);

	public Result deleteUser(HttpSession session, String ids);
}
