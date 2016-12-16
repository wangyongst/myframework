package com.myweb.controller;

import com.myweb.pojo.mybatis.Laoren;
import com.myweb.service.xnly.FrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BHWL on 2016-12-15.
 */


@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    public FrameworkService userService;

    //生成JSP页面

    @RequestMapping(value = "/xitong/user", method = RequestMethod.GET)
    public ModelAndView user(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getColumnsNameMap(session, map, "user", "tableColumns", true);
        map = userService.getTitleMap(session, map, "用户管理", "用户信息表");
        return new ModelAndView("xitong/user", map);
    }

    @RequestMapping(value = "/xitong/laoren", method = RequestMethod.GET)
    public ModelAndView laoren(HttpSession session, @ModelAttribute Laoren laoren) {
        Map map = new HashMap<String, String>();
        map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
        if (laoren.getType() == 1) {
            map = userService.getTitleMap(session, map, "低收入老人管理", "低收入老人信息表");
            return new ModelAndView("xitong/dSRLaoren", map);
        } else if (laoren.getType() == 2) {
            map = userService.getTitleMap(session, map, "饮马街街道老人管理", "饮马街街道老人信息表");
            return new ModelAndView("xitong/yMJLaoren", map);
        } else {
            map = userService.getTitleMap(session, map, "老人管理", "老人信息表");
            return new ModelAndView("xitong/laoren", map);
        }

    }

    @RequestMapping(value = "/xitong/laoren/jiashu", method = RequestMethod.GET)
    public ModelAndView laorenJiashu(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "老人家属管理", "老人家属信息表");
        map = userService.getColumnsNameMap(session, map, "jiashu", "tableColumns", true);
        return new ModelAndView("xitong/jiashu", map);
    }

    @RequestMapping(value = "/myhome", method = RequestMethod.GET)
    public ModelAndView myhome(HttpSession session) {
        Map map = new HashMap();
        map.put("title", "我的首页");
        map = userService.getMyHome(session, map);
        return new ModelAndView("default_home", map);
    }

    @RequestMapping(value = "/shenghuo/fuwu", method = RequestMethod.GET)
    public ModelAndView fuwu(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "服务记录/需求登记", "老人信息表");
        map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
        return new ModelAndView("shenghuo/fuwu", map);
    }

    @RequestMapping(value = "/shenghuo/fuwu/jilu", method = RequestMethod.GET)
    public ModelAndView jilu(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "服务记录管理", "服务记录表");
        map = userService.getColumnsNameMap(session, map, "fuwu", "tableColumns", true);
        return new ModelAndView("shenghuo/jilu", map);
    }

    @RequestMapping(value = "/shenghuo/fuwu/xuqiu", method = RequestMethod.GET)
    public ModelAndView xuqiu(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "服务需求管理", "服务需求表");
        map = userService.getColumnsNameMap(session, map, "fuwu", "tableColumns", true);
        return new ModelAndView("shenghuo/xuqiu", map);
    }

    @RequestMapping(value = "/jiankang/caiji", method = RequestMethod.GET)
    public ModelAndView caiji(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "健康数据采集", "老人信息表");
        map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
        return new ModelAndView("jiankang/caiji", map);
    }

    @RequestMapping(value = "/jiankang/caiji/qushi", method = RequestMethod.GET)
    public ModelAndView caijiQushi(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "健康趋势", "老人信息表");
        map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
        return new ModelAndView("jiankang/qushi", map);
    }


    @RequestMapping(value = "/jiankang/caiji/shuju", method = RequestMethod.GET)
    public ModelAndView caijiShuju(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "健康数据管理", "健康数据表");
        map = userService.getColumnsNameMap(session, map, "caiji", "tableColumns", true);
        return new ModelAndView("jiankang/shuju", map);
    }

    @RequestMapping(value = "/jiankang/caiji/qushi/shuju", method = RequestMethod.GET)
    public ModelAndView caijiQushiShuju(HttpSession session, String laorenid) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "健康数据趋势", "健康数据表");
        map = userService.getColumnsNameMap(session, map, "caiji", "tableColumns", true);
        map.put("laorenid", laorenid);
        return new ModelAndView("jiankang/qushishuju", map);
    }
}
