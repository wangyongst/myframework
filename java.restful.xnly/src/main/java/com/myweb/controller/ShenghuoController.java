package com.myweb.controller;


import com.myweb.pojo.mybatis.Fuwu;
import com.myweb.service.xnly.ShenghuoService;
import com.myweb.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/shenghuo")
public class ShenghuoController {

    @Autowired
    public ShenghuoService shenghuoService;

    @ResponseBody
    @RequestMapping(value = "/list/fuwus", method = RequestMethod.GET)
    public List<Fuwu> listFuwus(HttpSession session, String laorenid) {
        Fuwu fuwu = new Fuwu();
        if (StringUtils.isNotBlank(laorenid)) {
            fuwu.setLaorenid(Integer.parseInt(laorenid));
        }
        return shenghuoService.getAllFuwus(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/list/fuwu/jilus", method = RequestMethod.GET)
    public List<Fuwu> listFuwuJilus(HttpSession session, String laorenid) {
        Fuwu fuwu = new Fuwu();
        if (StringUtils.isNotBlank(laorenid)) {
            fuwu.setLaorenid(Integer.parseInt(laorenid));
        }
        return shenghuoService.getAllFuwuJilus(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/list/fuwu/xuqius", method = RequestMethod.GET)
    public List<Fuwu> listFuwuXuqius(HttpSession session, String laorenid) {
        Fuwu fuwu = new Fuwu();
        if (StringUtils.isNotBlank(laorenid)) {
            fuwu.setLaorenid(Integer.parseInt(laorenid));
        }
        return shenghuoService.getAllFuwuXuqius(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/get/fuwu", method = RequestMethod.GET)
    public Result fuwuGet(HttpSession session, String ids, String idType) {
        return shenghuoService.getFuwu(session, ids, idType);
    }

    @ResponseBody
    @RequestMapping(value = "/post/fuwu", method = RequestMethod.POST)
    public Result fuwuEdit(HttpSession session, @ModelAttribute Fuwu fuwu) {
        return shenghuoService.editFuwu(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/fuwu", method = RequestMethod.DELETE)
    public Result fuwuDelete(HttpSession session, String ids) {
        return shenghuoService.deleteFuwu(session, ids);
    }
}
