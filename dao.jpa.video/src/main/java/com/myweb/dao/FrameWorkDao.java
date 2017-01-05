package com.myweb.dao;

import com.myweb.pojo.User;

import java.util.List;

public interface FrameWorkDao {

    List<User> findUsersByUsernameAndPassword(String username, String password);

}
