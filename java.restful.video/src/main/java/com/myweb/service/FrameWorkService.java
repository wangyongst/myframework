package com.myweb.service;

import com.myweb.pojo.User;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;

public interface FrameWorkService {

    Result login(HttpSession session, User user);
    public Result playVideo(String platformid ,String url,String password);

}
