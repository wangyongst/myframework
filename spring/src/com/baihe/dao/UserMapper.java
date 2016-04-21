package com.baihe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baihe.base.BaseMapper;
import com.baihe.pojo.User;

/**
 * 用户Dao,用来访问数据库
 */

public interface UserMapper extends BaseMapper<User> {

	@Select("select * from user limit #{start}, #{pageSize}")
	public List<User> getPage(@Param("start") String start,
			@Param("pageSize") String pageSize);

	@Select("select count(*) from user")
	public long getCount();

	@Select("select * from user")
	public List<User> getAll();

	@Select("select * from user where username = #{user.username} and password = #{user.password}")
	public List<User> findAnd(@Param("user") User user);

	@Select("select * from user where username = #{user.username} or password = #{user.password}")
	public List<User> findOr(@Param("user") User user);

	@Select("select * from user where username like '%#{user.username}%' and password like '%#{user.password}%'")
	public List<User> findLikeAnd(@Param("user") User user);

	@Select("select * from user where username like '%#{user.username}%' or password like '%#{user.password}%'")
	public List<User> findLikeOr(@Param("user") User user);

	@Select("select * from user where id = #{id}")
	public User get(@Param("userid") User id);

}
