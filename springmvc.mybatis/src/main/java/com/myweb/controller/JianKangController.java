package com.myweb.controller;

import com.myweb.service.JianKangService;
import com.myweb.service.UserService;
import com.myweb.vo.Result;
import com.myweb.vo.mybatis.Caiji;
import com.myweb.vo.mybatis.Laoren;
import com.myweb.vo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/jiankang")
public class JianKangController {

    @Autowired
    public UserService userService;

    @Autowired
    public JianKangService jianKangService;

    @RequestMapping(value = "/caiji", method = RequestMethod.GET)
    public ModelAndView caiji(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map map = userService.getMyMenus(session);
        map.put("title", "健康数据采集");
        map = userService.getUserMap(map, session);
        map.put("tableName", "老人信息表");
        List<String> exclude = new ArrayList<String>();
        exclude.add("createuser");
        map = userService.getColumnsNameMap("laoren", map, session, exclude, null);
        map = userService.getColumnsNameMap("caiji", map, session, exclude, "formColumns");
        return new ModelAndView("jiankang/caiji", map);
    }

    @RequestMapping(value = "/qushi", method = RequestMethod.GET)
    public ModelAndView qushi(HttpSession session) {
        Map map = userService.getMyMenus(session);
        map.put("title", "健康趋势");
        map = userService.getUserMap(map, session);
        map.put("tableName", "老人信息表");
        List<String> exclude = new ArrayList<String>();
        exclude.add("createuser");
        map = userService.getColumnsNameMap("laoren", map, session, exclude, null);
        return new ModelAndView("jiankang/qushi", map);
    }

    @ResponseBody
    @RequestMapping(value = "/caiji/get", method = RequestMethod.POST)
    public Result laorenGet(HttpSession session, String ids) {
        return jianKangService.getCaiji(session, ids);
    }

    @ResponseBody
    @RequestMapping(value = "/caiji/edit", method = RequestMethod.POST)
    public Result laorenEdit(HttpSession session, String ids, @ModelAttribute Caiji caiji) {
        return jianKangService.editCaiji(session,caiji);
    }
}
