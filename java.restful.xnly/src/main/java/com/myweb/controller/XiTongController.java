package com.myweb.controller;

import com.myweb.pojo.mybatis.Jiashu;
import com.myweb.pojo.mybatis.Laoren;
import com.myweb.pojo.mybatis.User;
import com.myweb.service.xnly.FrameworkService;
import com.myweb.service.xnly.XiTongService;
import com.myweb.util.Page;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/xitong")
public class XiTongController {

    @Autowired
    public FrameworkService userService;
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
        return xiTongService.listLaorenJiashus(session, jiashu, page);
    }


    @ResponseBody
    @RequestMapping(value = "/list/laorens", method = RequestMethod.GET)
    public List<Laoren> listLaorens(HttpSession session, @ModelAttribute Laoren laoren, @ModelAttribute Page page) {
        return xiTongService.listLaorens(session, laoren, page);
    }


    //查询记录

    @ResponseBody
    @RequestMapping(value = "/get/laoren/jiashu/{id}", method = RequestMethod.GET)
    public Result getJiashu(HttpSession session, @PathVariable("id") String id) {
        return xiTongService.getJiashu(session, id);
    }

    @ResponseBody
    @RequestMapping(value = "/get/user/{id}", method = RequestMethod.GET)
    public Result getUser(HttpSession session, @PathVariable("id") String id) {
        return xiTongService.getUser(session, id);
    }

    @ResponseBody
    @RequestMapping(value = "/get/laoren/{id}", method = RequestMethod.GET)
    public Result getLaoren(HttpSession session, @PathVariable("id") String id) {
        return xiTongService.getLaoren(session, id);
    }


    //创建记录

    @ResponseBody
    @RequestMapping(value = "/post/laoren/jiashu", method = RequestMethod.POST)
    public Result postLaorenJiashu(HttpSession session, @ModelAttribute Jiashu jiashu) {
        return xiTongService.saveOrUpdateJiashu(session, jiashu);
    }

    @ResponseBody
    @RequestMapping(value = "/post/user", method = RequestMethod.POST)
    public Result postUser(HttpSession session, @ModelAttribute User user) {
        return xiTongService.saveOrUpdateUser(session, user);
    }

    @ResponseBody
    @RequestMapping(value = "/post/laoren", method = RequestMethod.POST)
    public Result postLaoren(HttpSession session, @ModelAttribute Laoren laoren) {
        return xiTongService.saveOrUpdateLaoren(session, laoren);
    }


    //修改记录

    @ResponseBody
    @RequestMapping(value = "/put/laoren/jiashu", method = RequestMethod.PUT)
    public Result putLaorenJiashu(HttpSession session, @ModelAttribute Jiashu jiashu) {
        return xiTongService.saveOrUpdateJiashu(session, jiashu);
    }

    @ResponseBody
    @RequestMapping(value = "/put/user", method = RequestMethod.PUT)
    public Result putUser(HttpSession session, @ModelAttribute User user) {
        return xiTongService.saveOrUpdateUser(session, user);
    }

    @ResponseBody
    @RequestMapping(value = "/put/laoren", method = RequestMethod.PUT)
    public Result putLaoren(HttpSession session, @ModelAttribute Laoren laoren) {
        return xiTongService.saveOrUpdateLaoren(session, laoren);
    }

    //删除记录

    @ResponseBody
    @RequestMapping(value = "/delete/laoren/jiashu/{id}", method = RequestMethod.DELETE)
    public Result deleteLaorenJiashu(HttpSession session, @PathVariable("id") String id) {
        return xiTongService.deleteJiashu(session, id);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.DELETE)
    public Result deleteUser(HttpSession session, @PathVariable("id") String id) {
        return xiTongService.deleteUser(session, id);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/laoren/{id}", method = RequestMethod.DELETE)
    public Result deleteLaoren(HttpSession session, @PathVariable("id") String id) {
        return xiTongService.deleteLaoren(session, id);
    }
}
