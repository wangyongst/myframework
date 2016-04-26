package com.myweb.service.impl;

import com.myweb.dao.mybatis.MenuMapper;
import com.myweb.dao.mybatis.RenyuanMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.service.UserService;
import com.myweb.service.XiTongService;
import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("xiTongService")
@Transactional
public class XiTongServiceImpl implements XiTongService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RenyuanMapper renyuanMapper;


    public List<User> getAllUsers(HttpSession session) {
       return userMapper.selectByExample(null);
    }

    public List<Renyuan> getAllRenyuans(HttpSession session) {
        return renyuanMapper.selectByExample(null);
    }
}
