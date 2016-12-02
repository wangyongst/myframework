package com.myweb.controller;

import com.myweb.pojo.mybatis.Jiashu;
import com.myweb.pojo.mybatis.Laoren;
import com.myweb.pojo.mybatis.User;
import com.myweb.service.xnly.UserService;
import com.myweb.service.xnly.XiTongService;
import com.myweb.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        Map map = userService.getTitleMap(session, "用户管理", "用户信息表");
        map = userService.getColumnsNameMap(session, map, "user", "tableColumns",true);
        map = userService.getColumnsNameMap(session, map, "user", "formColumns",false);
        return new ModelAndView("xitong/user", map);
    }

    @ResponseBody
    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public List<User> allUser(HttpSession session) {
        return xiTongService.getAllUsers(session);
    }

    @RequestMapping(value = "/laoren", method = RequestMethod.GET)
    public ModelAndView laoren(HttpSession session) {
        Map map = userService.getTitleMap(session, "老人管理", "老人信息表");
        map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns",true);
        map = userService.getColumnsNameMap(session, map, "laoren", "formColumns",false);
        map = userService.getColumnsNameMap(session, map, "jiashu", "jiashuColumns",false);
        map = userService.getColumnsShuxingMap(session, map, "bingshi", "bingshi");
        return new ModelAndView("xitong/laoren", map);
    }


    @RequestMapping(value = "/jiashu", method = RequestMethod.GET)
    public ModelAndView jiashu(HttpSession session) {
        Map map = userService.getTitleMap(session, "老人家属管理", "老人家属信息表");
        map = userService.getColumnsNameMap(session, map, "jiashu", "tableColumns",true);
        map = userService.getColumnsNameMap(session, map, "jiashu", "formColumns",false);
        return new ModelAndView("xitong/jiashu", map);
    }

    @ResponseBody
    @RequestMapping(value = "/jiashu/get", method = RequestMethod.POST)
    public Result jiashuGet(HttpSession session, String ids, String idType) {
        return xiTongService.getJiashu(session, ids, idType);
    }


    @ResponseBody
    @RequestMapping(value = "/jiashu/edit", method = RequestMethod.POST)
    public Result jiashuEdit(HttpSession session, String ids, @ModelAttribute Jiashu jiashu) {
        return xiTongService.editJiashu(session, jiashu);
    }


    @RequestMapping(value = "/dSRLaoren", method = RequestMethod.GET)
    public ModelAndView dSRLaoren(HttpSession session) {
        Map map = userService.getTitleMap(session, "低收入老人管理", "低收入老人信息表");
        map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns",true);
        map = userService.getColumnsNameMap(session, map, "laoren", "formColumns",false);
        map = userService.getColumnsNameMap(session, map, "jiashu", "jiashuColumns",false);
        map = userService.getColumnsShuxingMap(session, map, "bingshi", "bingshi");
        return new ModelAndView("xitong/dSRLaoren", map);
    }

    @RequestMapping(value = "/yMJLaoren", method = RequestMethod.GET)
    public ModelAndView yMjLaoren(HttpSession session) {
        Map map = userService.getTitleMap(session, "饮马街街道老人管理", "饮马街街道老人信息表");
        map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns",true);
        map = userService.getColumnsNameMap(session, map, "laoren", "formColumns",false);
        map = userService.getColumnsNameMap(session, map, "jiashu", "jiashuColumns",false);
        map = userService.getColumnsShuxingMap(session, map, "bingshi", "bingshi");
        return new ModelAndView("xitong/yMJLaoren", map);
    }


    @ResponseBody
    @RequestMapping(value = "/allJiashus", method = RequestMethod.GET)
    public List<Jiashu> allJiashus(HttpSession session) {
        return xiTongService.getAllJiashus(session);
    }

    @ResponseBody
    @RequestMapping(value = "/allLaorens", method = RequestMethod.GET)
    public List<Laoren> allLaorens(HttpSession session) {
        return xiTongService.getAllLaorens(session);
    }

    @ResponseBody
    @RequestMapping(value = "/dSRLaorens", method = RequestMethod.GET)
    public List<Laoren> dSRLaorens(HttpSession session) {
        return xiTongService.getDSRLaorens(session);
    }

    @ResponseBody
    @RequestMapping(value = "/yMJLaorens", method = RequestMethod.GET)
    public List<Laoren> yMJLaorens(HttpSession session) {
        return xiTongService.getYMJLaorens(session);
    }

    @ResponseBody
    @RequestMapping(value = "/otherLaorens", method = RequestMethod.GET)
    public List<Laoren> otherLaorens(HttpSession session) {
        return xiTongService.getOtherLaorens(session);
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
    @RequestMapping(value = "/laoren/yMJEdit", method = RequestMethod.POST)
    public Result yMjLaorenEdit(HttpSession session, String ids, @ModelAttribute Laoren laoren) {
        return xiTongService.editYMJLaoren(session, laoren);
    }

    @ResponseBody
    @RequestMapping(value = "/laoren/dSREdit", method = RequestMethod.POST)
    public Result dSRLaorenEdit(HttpSession session, String ids, @ModelAttribute Laoren laoren) {
        return xiTongService.editDSRLaoren(session, laoren);
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

    @ResponseBody
    @RequestMapping(value = "/jiashu/delete", method = RequestMethod.POST)
    public Result jiashuDelete(HttpSession session, String ids) {
        return xiTongService.deleteJiashu(session, ids);
    }

    @ResponseBody
    @RequestMapping(value = "/laoren/change", method = RequestMethod.POST)
    public Result laorenChange(HttpSession session, String ids) {
        return xiTongService.changeLaoren(session, ids);
    }
}
