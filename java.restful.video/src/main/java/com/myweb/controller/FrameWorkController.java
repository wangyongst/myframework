package com.myweb.controller;

import com.myweb.pojo.User;
import com.myweb.service.FrameWorkService;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/framework")
public class FrameWorkController {

    @Autowired
    public FrameWorkService frameWorkService;

    //登录
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public Result login(HttpSession session, @ModelAttribute User user) {
        return frameWorkService.login(session, user);
    }

    //首页
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {
        Map map = new HashMap();
        return new ModelAndView("home", map);
    }
}
