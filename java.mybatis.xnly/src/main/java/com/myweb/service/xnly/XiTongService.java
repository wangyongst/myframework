package com.myweb.service.xnly;


import com.myweb.pojo.mybatis.Jiashu;
import com.myweb.pojo.mybatis.Laoren;
import com.myweb.pojo.mybatis.User;
import com.myweb.util.Page;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface XiTongService {

    public List<User> listUsers(HttpSession session, User user, Page page);

    public List<Laoren> listLaorens(HttpSession session, Laoren laoren, Page page);

    public List<Jiashu> listJiashus(HttpSession session, Jiashu jiashu, Page page);


    public Result getJiashu(HttpSession session, String id);

    public Result getLaoren(HttpSession session, String id);

    public Result getUser(HttpSession session, String id);


    public Result saveOrUpdateLaoren(HttpSession session, Laoren laoren);

    public Result saveOrUpdateUser(HttpSession session, User user);

    public Result saveOrUpdateJiashu(HttpSession session, Jiashu jiashu);

    public Result changeLaorenType(HttpSession session, String id, String type);

    public Result deleteJiashu(HttpSession session, String id);

    public Result deleteLaoren(HttpSession session, String id);

    public Result deleteUser(HttpSession session, String id);
}
