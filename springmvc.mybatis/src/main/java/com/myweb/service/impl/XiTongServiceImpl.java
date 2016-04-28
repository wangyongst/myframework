package com.myweb.service.impl;

import com.myweb.dao.mybatis.RenyuanMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.service.XiTongService;
import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.Renyuan;
import com.myweb.vo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("xiTongService")
@Transactional
public class XiTongServiceImpl implements XiTongService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RenyuanMapper renyuanMapper;


    public List<User> getAllUsers(HttpSession session) {
        return userMapper.selectByExample(null);
    }

    public List<Renyuan> getAllRenyuans(HttpSession session) {
        return renyuanMapper.selectByExample(null);
    }

    public JsonResult getRenyuan(HttpSession session, Renyuan renyuan) {
        JsonResult json = new JsonResult();
        json.setData(renyuanMapper.selectByPrimaryKey(renyuan.getId()));
        return json;
    }

    public JsonResult getUser(HttpSession session, User user) {
        JsonResult json = new JsonResult();
        json.setData(userMapper.selectByPrimaryKey(user.getId()));
        return json;
    }

    public JsonResult editRenyuan(HttpSession session, Renyuan renyuan) {
        JsonResult json = new JsonResult();
        return json;
    }

    public JsonResult editUser(HttpSession session, User user) {
        JsonResult json = new JsonResult();
        return json;
    }

    public JsonResult deleteRenyuan(HttpSession session, Renyuan renyuan) {
        JsonResult json = new JsonResult();
        json.setData(renyuanMapper.deleteByPrimaryKey(renyuan.getId()));
        return json;
    }

    public JsonResult deleteUser(HttpSession session, User user) {
        JsonResult json = new JsonResult();
        json.setData(userMapper.deleteByPrimaryKey(user.getId()));
        return json;
    }

}
