package com.myweb.controller;

import com.myweb.service.VideoService;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/video")
public class VideoController {

    @Autowired
    public VideoService videoService;

    @ResponseBody
    @RequestMapping(value = "/get/video/{password}", method = RequestMethod.POST)
    public Result getJiashu(HttpSession session, String url, @PathVariable("password") String password) {
        return videoService.playVideo(url, password);
    }
}
