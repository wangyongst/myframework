package com.myweb.service.xnly.impl;

import com.myweb.dao.mybatis.*;
import com.myweb.pojo.mybatis.*;
import com.myweb.service.xnly.FrameworkService;
import com.myweb.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("frameworkService")
@Transactional(value = "myTM", readOnly = true)
public class FrameworkServiceImpl implements FrameworkService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private TableinfoMapper tableinfoMapper;

    @Autowired
    private ShuxingMapper shuxingMapper;

    @Autowired
    private Role2menuMapper role2menuMapper;

    @Autowired
    private LaorenMapper laorenMapper;

    @Autowired
    private CaijiMapper caijiMapper;

    @Autowired
    private FuwuMapper fuwuMapper;

    @Override
    public Result login(HttpSession session, User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        Result result = new Result();
        if (userList.size() == 0) {
            result.setMessage("用户名或密码错误，请重新检查您的输入！");
        } else if (userList.size() > 1) {
            result.setStatus(2);
            result.setMessage("你的账号有异常，请发送邮件到：331527770@qq.com联系管理员处理！");
        } else {
            result.setStatus(0);
            session.setAttribute("user", userList.get(0));
        }
        return result;
    }


    public Result logout(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }

    @Override
    public Map<String, Object> getMyMenus(HttpSession session) {
        Map map = new HashMap<String, String>();
        MenuExample parent = new MenuExample();
        MenuExample children = new MenuExample();
        User user = (User) session.getAttribute("user");
        MenuExample.Criteria parentCriteria = parent.createCriteria();
        MenuExample.Criteria childrenCriteria = children.createCriteria();
        if (!user.getUsername().equals("super")) {
            Role2menuExample u2mExapmle = new Role2menuExample();
            u2mExapmle.createCriteria().andRoleEqualTo(user.getRole());
            List<Role2menu> u2mList = role2menuMapper.selectByExample(u2mExapmle);
            List<Integer> value = new ArrayList<Integer>();
            for (Role2menu u2m : u2mList) {
                value.add(u2m.getMenuid());
            }
            parentCriteria.andIdIn(value);
            childrenCriteria.andIdIn(value);
        }
        parentCriteria.andParentEqualTo(0);
        childrenCriteria.andParentNotEqualTo(0);
        parent.setOrderByClause("shunxu");
        children.setOrderByClause("shunxu");
        map.put("parent", menuMapper.selectByExample(parent));
        map.put("children", menuMapper.selectByExample(children));
        return map;
    }

    @Override
    public Map<String, Object> getMyHome(HttpSession session, Map<String, Object> map) {
        map.put("totalLaoren", laorenMapper.countByExample(null));
        map.put("totalCaiji", caijiMapper.countByExample(null));
        FuwuExample fje = new FuwuExample();
        fje.createCriteria().andFuwutypeEqualTo("服务记录");
        map.put("totalFuwuJilu", fuwuMapper.countByExample(fje));
        FuwuExample fjx = new FuwuExample();
        fjx.createCriteria().andFuwutypeEqualTo("服务需求");
        map.put("totalFuwuXuqiu", fuwuMapper.countByExample(fjx));
        return map;
    }

    @Override
    public Map<String, Object> getUserMenuMap(HttpSession session, Map<String, Object> map) {
        Menu profile = new Menu();
        profile.setName("个人信息");
        profile.setUrl("user/profile.do");
        map.put("profile", profile);
        Menu settings = new Menu();
        settings.setName("账号设置");
        settings.setUrl("user/settings.do");
        map.put("settings", settings);
        Menu logout = new Menu();
        logout.setName("退出登录");
        logout.setUrl("user/logout.do");
        map.put("logout", logout);
        return map;
    }

    @Override
    public Map<String, Object> getColumnsNameMap(HttpSession session, Map<String, Object> map, String tableName, String columns, boolean isTable) {
        if (StringUtils.isNotBlank(columns)) {
            TableinfoExample tableinfoExample = new TableinfoExample();
            if (isTable) {
                tableinfoExample.createCriteria().andTablenameEqualTo(tableName).andTabledisableIsNull();
            } else {
                tableinfoExample.createCriteria().andTablenameEqualTo(tableName).andModaldisableIsNull();
            }
            tableinfoExample.setOrderByClause("shunxu");
            map.put(columns, tableinfoMapper.selectByExample(tableinfoExample));
        }
        return map;
    }


    @Override
    public Map<String, Object> getColumnsShuxingMap(HttpSession session, Map<String, Object> map, String columnName, String name) {
        if (StringUtils.isNotBlank(columnName) && StringUtils.isNotBlank(name)) {
            ShuxingExample shuxingExample = new ShuxingExample();
            shuxingExample.createCriteria().andNameEqualTo(name);
            shuxingExample.setOrderByClause("shunxu");
            map.put(columnName, shuxingMapper.selectByExample(shuxingExample));
        }
        return map;
    }

    @Override
    public Result getShuxing(HttpSession session, String name) {
        Result result = new Result();
        if (StringUtils.isNotBlank(name)) {
            ShuxingExample shuxingExample = new ShuxingExample();
            shuxingExample.createCriteria().andNameEqualTo(name);
            shuxingExample.setOrderByClause("shunxu");
            result.setData(shuxingMapper.selectByExample(shuxingExample));
        }
        return result;
    }

    @Override
    public Result getTableinfo(HttpSession session, String tablename, boolean notTable) {
        Result result = new Result();
        TableinfoExample tableinfoExample = new TableinfoExample();
        if (!notTable) {
            tableinfoExample.createCriteria().andTablenameEqualTo(tablename).andTabledisableIsNull();
        } else {
            tableinfoExample.createCriteria().andTablenameEqualTo(tablename).andModaldisableIsNull();
        }
        tableinfoExample.setOrderByClause("shunxu");
        result.setData(tableinfoMapper.selectByExample(tableinfoExample));
        return result;
    }

    @Override
    public Map<String, Object> getTitleMap(HttpSession session, Map<String, Object> map, String title, String tableTitle) {
        map.put("title", title);
        map.put("tableName", tableTitle);
        map.put("home", "menu/myhome.do");
        return map;
    }
}
