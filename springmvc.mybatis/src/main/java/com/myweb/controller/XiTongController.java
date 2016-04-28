package com.myweb.controller;

import com.myweb.service.UserService;
import com.myweb.service.XiTongService;
import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.Renyuan;
import com.myweb.vo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/xitong")
public class XiTongController {

    @Autowired
    public UserService userService;
    @Autowired
    public XiTongService xiTongService;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(HttpSession session) {
        Map map = userService.getMyMenus(session);
        map.put("title", "用户管理");
        map = userService.getUserMap(map, session);
        map.put("tableName", "用户信息表");
        map = userService.getColumnsNameMap("user", map, session);
        return new ModelAndView("xitong/user", map);
    }

    @ResponseBody
    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public List<User> allUser(HttpSession session) {
        return xiTongService.getAllUsers(session);
    }

    @RequestMapping(value = "/renyuan", method = RequestMethod.GET)
    public ModelAndView renyuan(HttpSession session) {
        Map map = userService.getMyMenus(session);
        map.put("title", "人员管理");
        map = userService.getUserMap(map, session);
        map.put("tableName", "人员信息表");
        map = userService.getColumnsNameMap("renyuan", map, session);
        return new ModelAndView("xitong/renyuan", map);
    }

    @ResponseBody
    @RequestMapping(value = "/allRenyuans", method = RequestMethod.GET)
    public List<Renyuan> allRenyuans(HttpSession session) {
        return xiTongService.getAllRenyuans(session);
    }


    @ResponseBody
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public JsonResult userEdit(HttpSession session, Integer id, String name, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setId(id);
        return xiTongService.editUser(session, user);
    }

    @ResponseBody
    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public JsonResult userDelete(HttpSession session, Integer id) {
        User user = new User();
        user.setId(id);
        return xiTongService.editUser(session, user);
    }
}
