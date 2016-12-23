package com.myweb.controller;

import com.myweb.pojo.User;
import com.myweb.service.VideoService;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/video")
public class VideoController {

    @Autowired
    public VideoService videoService;

    @ResponseBody
    @RequestMapping(value = "/get/video/{url}/{password}", method = RequestMethod.GET)
    public Result getJiashu(HttpSession session, @PathVariable("url") String url, @PathVariable("password") String password) {
        System.out.println(url);
        System.out.println(password);
        return new Result();
    }
}
