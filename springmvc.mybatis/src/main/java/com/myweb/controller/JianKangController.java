package com.myweb.controller;

import com.myweb.service.UserService;
import com.myweb.vo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/jiankang")
public class JianKangController {

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/caiji", method = RequestMethod.GET)
    public ModelAndView caiji(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null){
            return new ModelAndView("login");
        }
        Map map = userService.getMyMenus(user);
        map.put("title","数据采集");
        map = userService.getUserMap(map,session);
        map = userService.getColumnsNameMap("renyuan", map, session);
        return new ModelAndView("jiankang/caiji", map);
    }

    @RequestMapping(value = "/qushi", method = RequestMethod.GET)
    public ModelAndView qushi(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null){
            return new ModelAndView("login");
        }
        Map map = userService.getMyMenus(user);
        map.put("title","健康趋势");
        map = userService.getUserMap(map,session);
        map = userService.getColumnsNameMap("renyuan", map, session);
        return new ModelAndView("jiankang/qushi",  map );
    }
}
