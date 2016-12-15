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

    public List<Laoren> listLaorens(HttpSession session, Laoren laoren);

    public List<Jiashu> listLaorenJiashus(HttpSession session);


    public Result getJiashu(HttpSession session, String ids, String idType);

    public Result getLaoren(HttpSession session, String ids);

    public Result getUser(HttpSession session, String ids);

    public Result editJiashu(HttpSession session, Jiashu jiashu);

    public Result deleteJiashu(HttpSession session, String ids);


    public Result editLaoren(HttpSession session, Laoren laoren);

    public Result editUser(HttpSession session, User user);

    public Result deleteLaoren(HttpSession session, String ids);

    public Result deleteUser(HttpSession session, String ids);
}
