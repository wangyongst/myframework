package com.myweb.controller;

import com.myweb.pojo.mybatis.User;
import com.myweb.service.xnly.UserService;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    public UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(HttpSession session,@ModelAttribute User user) {
        return userService.login(session,user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        userService.logout(session);
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {
        Map map =  userService.getMyMenus(session);
        map = userService.getUserMap(session,map);
        return new ModelAndView("home", map);
    }

    @ResponseBody
    @RequestMapping(value = "/getColumns", method = RequestMethod.GET)
    public Result getColumns(@RequestParam("name") String name, HttpSession session) {
        return userService.getColumnsShuxingList(session,name);
    }
}
