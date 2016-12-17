package com.myweb.controller;


import com.myweb.pojo.mybatis.Caiji;
import com.myweb.pojo.mybatis.Fuwu;
import com.myweb.service.xnly.ShenghuoService;
import com.myweb.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/shenghuo")
public class ShenghuoController {

    @Autowired
    public ShenghuoService shenghuoService;

    @ResponseBody
    @RequestMapping(value = "/list/fuwus", method = RequestMethod.GET)
    public List<Fuwu> listFuwus(HttpSession session, @ModelAttribute Fuwu fuwu) {
        return shenghuoService.listFuwus(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/get/fuwu/{id}", method = RequestMethod.GET)
    public Result getFuwu(HttpSession session, @PathVariable("id") String id) {
        return shenghuoService.getFuwu(session, id);
    }

    @ResponseBody
    @RequestMapping(value = "/post/fuwu", method = RequestMethod.POST)
    public Result postFuwu(HttpSession session, @ModelAttribute Fuwu fuwu) {
        return shenghuoService.createFuwu(session, fuwu);
    }


    @ResponseBody
    @RequestMapping(value = "/put/fuwu", method = RequestMethod.PUT)
    public Result putFuwu(HttpSession session, @ModelAttribute Fuwu fuwu) {
        return shenghuoService.updateFuwu(session, fuwu);
    }


    @ResponseBody
    @RequestMapping(value = "/delete/fuwu/{id}", method = RequestMethod.DELETE)
    public Result deleteFuwu(HttpSession session, @PathVariable("id") String id) {
        return shenghuoService.deleteFuwu(session, id);
    }
}
