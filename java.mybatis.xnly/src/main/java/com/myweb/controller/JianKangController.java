package com.myweb.controller;


import com.myweb.pojo.mybatis.Caiji;
import com.myweb.service.xnly.JianKangService;
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
@RequestMapping(value = "/jiankang")
public class JianKangController {


    @Autowired
    public JianKangService jianKangService;


    @ResponseBody
    @RequestMapping(value = "/list/caijis", method = RequestMethod.GET)
    public List<Caiji> allCaijis(HttpSession session, @ModelAttribute Caiji caiji) {
        return jianKangService.getAllCaijis(session, caiji);
    }

    @ResponseBody
    @RequestMapping(value = "/get/caiji", method = RequestMethod.GET)
    public Result getCaiji(HttpSession session, String ids, String idType) {
        return jianKangService.getCaiji(session, ids, idType);
    }

    @ResponseBody
    @RequestMapping(value = "/post/caiji", method = RequestMethod.POST)
    public Result postCaiji(HttpSession session, @ModelAttribute Caiji caiji) {
        return jianKangService.editCaiji(session, caiji);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/caiji", method = RequestMethod.DELETE)
    public Result deleteCaiji(HttpSession session, String ids) {
        return jianKangService.deleteCaiji(session, ids);
    }
}
