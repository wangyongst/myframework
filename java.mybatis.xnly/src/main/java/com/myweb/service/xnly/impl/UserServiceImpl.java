package com.myweb.service.xnly.impl;

import com.myweb.dao.mybatis.*;
import com.myweb.pojo.mybatis.*;
import com.myweb.service.xnly.UserService;
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

@Service("userService")
@Transactional(value = "myTM", readOnly = true)
public class UserServiceImpl implements UserService {

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
    public Result login(HttpSession session, String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(example);
        Result result = new Result();
        if (userList.size() == 0) {
            result.setStatus(1);
            result.setMessage("用户名或密码错误，请重新检查您的输入！");
        } else if (userList.size() > 1) {
            result.setStatus(2);
            result.setMessage("有多个相同用户，请发送邮件到：331527770@qq.com联系管理员！");
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
        map.put("totalLaoren",laorenMapper.countByExample(null));
        map.put("totalCaiji",caijiMapper.countByExample(null));
        FuwuExample fje = new FuwuExample();
        fje.createCriteria().andFuwutypeEqualTo("服务记录");
        map.put("totalFuwuJilu",fuwuMapper.countByExample(fje));
        FuwuExample fjx = new FuwuExample();
        fjx.createCriteria().andFuwutypeEqualTo("服务记录");
        map.put("totalFuwuXuqiu",fuwuMapper.countByExample(fjx));
        return map;
    }

    @Override
    public Map<String, Object> getUserMap(HttpSession session, Map<String, Object> map) {
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
    public Map<String, Object> getColumnsShuxingMap(HttpSession session, Map<String, Object> map, String columnName, String type) {
        if (StringUtils.isNotBlank(columnName) && StringUtils.isNotBlank(type)) {
            ShuxingExample shuxingExample = new ShuxingExample();
            shuxingExample.createCriteria().andTypeEqualTo(type);
            shuxingExample.setOrderByClause("shunxu");
            map.put(columnName, shuxingMapper.selectByExample(shuxingExample));
        }
        return map;
    }

    @Override
    public Map<String, Object> getTitleMap(HttpSession session, String title, String tableTitle) {
        Map map = new HashMap<String, String>();
        map.put("title", title);
        map.put("tableName", tableTitle);
        return map;
    }
}
