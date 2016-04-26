package com.myweb.service.impl;

import com.myweb.dao.mybatis.MenuMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.service.UserService;
import com.myweb.vo.JsonResult;
import com.myweb.vo.mybatis.Menu;
import com.myweb.vo.mybatis.MenuExample;
import com.myweb.vo.mybatis.User;
import com.myweb.vo.mybatis.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    public JsonResult login(String username, String password,
                            HttpSession session) {

        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(example);
        JsonResult json = new JsonResult();
        if (userList.size() == 0) {
            json.setStatus(1);
            json.setMessage("用户名或密码错误，请重新检查您的输入！");
        } else if (userList.size() > 1) {
            json.setStatus(2);
            json.setMessage("有多个相同用户，请发送邮件到：331527770@qq.com联系管理员！");
        } else {
            json.setStatus(0);
            session.setAttribute("user", userList.get(0));
        }
        return json;
    }

    public Map<String, Object> getMyMenus(User user) {
        Map map = new HashMap<String, String>();
        map.put("user", user);
        map.put("menu", menuMapper.selectByExample(null));
        MenuExample children = new MenuExample();
        children.createCriteria().andParentNotEqualTo(0);
        map.put("children",menuMapper.selectByExample(children));
        return map;
    }
}
