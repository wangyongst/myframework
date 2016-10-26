package com.myweb.controller;

import com.myweb.service.xnly.UserService;
import com.myweb.service.xnly.XiTongService;
import com.myweb.vo.Result;
import com.myweb.pojo.mybatis.Laoren;
import com.myweb.pojo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
        Map map = new HashMap<String, String>();
        map.put("title", "用户管理");
        map = userService.getUserMap(map, session);
        map.put("tableName", "用户信息表");
        map = userService.getColumnsNameMap("user", map, session, "tableColumns");
        map = userService.getColumnsNameMap("user", map, session, "formColumns");
        return new ModelAndView("xitong/user", map);
    }

    @ResponseBody
    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public List<User> allUser(HttpSession session) {
        return xiTongService.getAllUsers(session);
    }

    @RequestMapping(value = "/laoren", method = RequestMethod.GET)
    public ModelAndView laoren(HttpSession session) {
        Map map = new HashMap<String, String>();
        map.put("title", "老人管理");
        map = userService.getUserMap(map, session);
        map.put("tableName", "老人信息表");
        map = userService.getColumnsNameMap("laoren", map, session, "tableColumns");
        map = userService.getColumnsNameMap("laoren", map, session, "formColumns");
        return new ModelAndView("xitong/laoren", map);
    }

    @ResponseBody
    @RequestMapping(value = "/allLaorens", method = RequestMethod.GET)
    public List<Laoren> allLaorens(HttpSession session) {
        return xiTongService.getAllLaorens(session);
    }

    @ResponseBody
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public Result userEdit(HttpSession session, String ids, @ModelAttribute User user) {
        return xiTongService.editUser(session, user);
    }

    @ResponseBody
    @RequestMapping(value = "/laoren/edit", method = RequestMethod.POST)
    public Result laorenEdit(HttpSession session, String ids, @ModelAttribute Laoren laoren) {
        return xiTongService.editLaoren(session, laoren);
    }

    @ResponseBody
    @RequestMapping(value = "/user/get", method = RequestMethod.POST)
    public Result userGet(HttpSession session, String ids) {
        return xiTongService.getUser(session, ids);
    }

    @ResponseBody
    @RequestMapping(value = "/laoren/get", method = RequestMethod.POST)
    public Result laorenGet(HttpSession session, String ids) {
        return xiTongService.getLaoren(session, ids);
    }

    @ResponseBody
    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public Result userDelete(HttpSession session, String ids) {
        return xiTongService.deleteUser(session, ids);
    }

    @ResponseBody
    @RequestMapping(value = "/laoren/delete", method = RequestMethod.POST)
    public Result laorenDelete(HttpSession session, String ids) {
        return xiTongService.deleteLaoren(session, ids);
    }
}
