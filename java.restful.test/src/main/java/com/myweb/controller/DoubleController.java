package com.myweb.controller;


import com.myweb.pojo.*;
import com.myweb.service.DoubleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/xuexi")
public class DoubleController {

    @Autowired
    private DoubleService doubleService;


    //修改
    @ResponseBody
    @RequestMapping(value = "createHaochi", method = RequestMethod.POST)
    public void updateUser(HttpSession session) {
        doubleService.createHaochi(session);
    }


}
