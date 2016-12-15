package com.myweb.controller;

import com.myweb.pojo.mybatis.Jiashu;
import com.myweb.pojo.mybatis.Laoren;
import com.myweb.pojo.mybatis.User;
import com.myweb.service.xnly.UserService;
import com.myweb.service.xnly.XiTongService;
import com.myweb.util.Page;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/xitong")
public class XiTongController {

    @Autowired
    public UserService userService;
    @Autowired
    public XiTongService xiTongService;

    //查询数据列表

    @ResponseBody
    @RequestMapping(value = "/list/users", method = RequestMethod.GET)
    public List<User> listUsers(HttpSession session, @ModelAttribute User user, @ModelAttribute Page page) {
        return xiTongService.listUsers(session, user, page);
    }

    @ResponseBody
    @RequestMapping(value = "/list/laoren/jiashus", method = RequestMethod.GET)
    public List<Jiashu> listLaorenJiashus(HttpSession session, @ModelAttribute Jiashu jiashu, @ModelAttribute Page page) {
        return xiTongService.listLaorenJiashus(session);
    }


    @ResponseBody
    @RequestMapping(value = "/list/laorens", method = RequestMethod.GET)
    public List<Laoren> listLaorens(HttpSession session, @ModelAttribute Laoren laoren, @ModelAttribute Page page) {
        return xiTongService.listLaorens(session, laoren);
    }


    //查询记录

    @ResponseBody
    @RequestMapping(value = "/get/laoren/jiashu", method = RequestMethod.GET)
    public Result getJiashu(HttpSession session, String ids, String idType, @ModelAttribute Jiashu jiashu) {
        return xiTongService.getJiashu(session, ids, idType);
    }

    @ResponseBody
    @RequestMapping(value = "/get/user", method = RequestMethod.GET)
    public Result getUser(HttpSession session, String ids, @ModelAttribute User user) {
        return xiTongService.getUser(session, ids);
    }

    @ResponseBody
    @RequestMapping(value = "/get/laoren", method = RequestMethod.GET)
    public Result getLaoren(HttpSession session, String ids, @ModelAttribute Laoren laoren) {
        return xiTongService.getLaoren(session, ids);
    }


    //创建记录

    @ResponseBody
    @RequestMapping(value = "/post/laoren/jiashu", method = RequestMethod.POST)
    public Result postLaorenJiashu(HttpSession session, @ModelAttribute Jiashu jiashu) {
        return xiTongService.editJiashu(session, jiashu);
    }

    @ResponseBody
    @RequestMapping(value = "/post/user", method = RequestMethod.POST)
    public Result postUser(HttpSession session, @ModelAttribute User user) {
        return xiTongService.editUser(session, user);
    }

    @ResponseBody
    @RequestMapping(value = "/post/laoren", method = RequestMethod.POST)
    public Result postLaoren(HttpSession session, @ModelAttribute Laoren laoren) {
        return xiTongService.editLaoren(session, laoren);
    }


    //修改记录

    @ResponseBody
    @RequestMapping(value = "/put/laoren/jiashu", method = RequestMethod.PUT)
    public Result putLaorenJiashu(HttpSession session, @ModelAttribute Jiashu jiashu) {
        return xiTongService.editJiashu(session, jiashu);
    }

    @ResponseBody
    @RequestMapping(value = "/post/user", method = RequestMethod.PUT)
    public Result putUser(HttpSession session, @ModelAttribute User user) {
        return xiTongService.editUser(session, user);
    }

    @ResponseBody
    @RequestMapping(value = "/post/laoren", method = RequestMethod.PUT)
    public Result putLaoren(HttpSession session, @ModelAttribute Laoren laoren) {
        return xiTongService.editLaoren(session, laoren);
    }

    //删除记录

    @ResponseBody
    @RequestMapping(value = "/delete/laoren/jiashu", method = RequestMethod.DELETE)
    public Result deleteLaorenJiashu(HttpSession session, String ids, @ModelAttribute Jiashu jiashu) {
        return xiTongService.deleteJiashu(session, ids);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/user", method = RequestMethod.DELETE)
    public Result deleteUser(HttpSession session, String ids, @ModelAttribute User user) {
        return xiTongService.deleteUser(session, ids);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/laoren", method = RequestMethod.DELETE)
    public Result deleteLaoren(HttpSession session, String ids, @ModelAttribute Laoren laoren) {
        return xiTongService.deleteLaoren(session, ids);
    }
}
