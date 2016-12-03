package com.myweb.controller;


import com.myweb.pojo.mybatis.Caiji;
import com.myweb.pojo.mybatis.Fuwu;
import com.myweb.service.xnly.JianKangService;
import com.myweb.service.xnly.ShenghuoService;
import com.myweb.service.xnly.UserService;
import com.myweb.util.Result;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping(value = "/shenghuo")
public class ShenghuoController {

    @Autowired
    public UserService userService;

    @Autowired
    public ShenghuoService shenghuoService;

    @RequestMapping(value = "/fuwu", method = RequestMethod.GET)
    public ModelAndView caiji(HttpSession session) {
        Map map = userService.getTitleMap(session, "服务记录/需求登记", "老人信息表");
        map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
        map = userService.getColumnsNameMap(session, map, "fuwu", "formColumns", false);
        map = userService.getColumnsShuxingMap(session, map, "xiangmu", "xiangmu");
        map = userService.getColumnsShuxingMap(session, map, "fuwutype", "fuwutype");
        return new ModelAndView("shenghuo/fuwu", map);
    }

    @RequestMapping(value = "/jilu", method = RequestMethod.GET)
    public ModelAndView jilu(HttpSession session) {
        Map map = userService.getTitleMap(session, "服务记录管理", "服务记录表");
        map = userService.getColumnsNameMap(session, map, "fuwu", "tableColumns", true);
        map = userService.getColumnsNameMap(session, map, "fuwu", "formColumns", false);
        map = userService.getColumnsShuxingMap(session, map, "xiangmu", "xiangmu");
        map = userService.getColumnsShuxingMap(session, map, "fuwutype", "fuwutype");
        return new ModelAndView("shenghuo/jilu", map);
    }

    @RequestMapping(value = "/xuqiu", method = RequestMethod.GET)
    public ModelAndView xuqiu(HttpSession session) {
        Map map = userService.getTitleMap(session, "服务需求管理", "服务需求表");
        map = userService.getColumnsNameMap(session, map, "fuwu", "tableColumns", true);
        map = userService.getColumnsNameMap(session, map, "fuwu", "formColumns", false);
        map = userService.getColumnsShuxingMap(session, map, "xiangmu", "xiangmu");
        map = userService.getColumnsShuxingMap(session, map, "fuwutype", "fuwutype");
        return new ModelAndView("shenghuo/xuqiu", map);
    }

    @ResponseBody
    @RequestMapping(value = "/allFuwus", method = RequestMethod.GET)
    public List<Fuwu> allCaijis(HttpSession session, String laorenid) {
        Fuwu fuwu = new Fuwu();
        if (StringUtils.isNotBlank(laorenid)) {
            fuwu.setLaorenid(Integer.parseInt(laorenid));
        }
        return shenghuoService.getAllFuwus(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/allFuwuJilus", method = RequestMethod.GET)
    public List<Fuwu> allFuwuJilus(HttpSession session, String laorenid) {
        Fuwu fuwu = new Fuwu();
        if (StringUtils.isNotBlank(laorenid)) {
            fuwu.setLaorenid(Integer.parseInt(laorenid));
        }
        return shenghuoService.getAllFuwuJilus(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/allFuwuXuqius", method = RequestMethod.GET)
    public List<Fuwu> allFuwuXuqius(HttpSession session, String laorenid) {
        Fuwu fuwu = new Fuwu();
        if (StringUtils.isNotBlank(laorenid)) {
            fuwu.setLaorenid(Integer.parseInt(laorenid));
        }
        return shenghuoService.getAllFuwuXuqius(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/fuwu/get", method = RequestMethod.POST)
    public Result fuwuGet(HttpSession session, String ids, String idType) {
        return shenghuoService.getFuwu(session, ids, idType);
    }

    @ResponseBody
    @RequestMapping(value = "/fuwu/edit", method = RequestMethod.POST)
    public Result fuwuEdit(HttpSession session, @ModelAttribute Fuwu fuwu) {
        return shenghuoService.editFuwu(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/fuwu/delete", method = RequestMethod.POST)
    public Result fuwuDelete(HttpSession session, String ids) {
        return shenghuoService.deleteFuwu(session, ids);
    }
}
