package com.myweb.controller;

import com.myweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/xitong")
public class VideoController {

    @Autowired
    public VideoService xiTongService;


}
