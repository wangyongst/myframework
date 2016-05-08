package com.myweb.controller;

import com.myweb.service.xnly.UserService;
import com.myweb.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    public UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session) {
        return userService.login(username, password, session);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        userService.logout(session);
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {
        Map map = userService.getMyMenus(session);
        map = userService.getUserMap(map, session);
        map.put("title", "我的首页");
        return new ModelAndView("home", map);
    }
}
