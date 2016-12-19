package com.myweb.service.impl;

import com.myweb.dao.*;
import com.myweb.pojo.*;
import com.myweb.service.FrameworkService;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
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
    private RoletomenuMapper roletomenuMapper;

    @Autowired
    private LaorenMapper laorenMapper;

    @Autowired
    private CaijiMapper caijiMapper;

    @Autowired
    private FuwuMapper fuwuMapper;

    @Override
    public Result login(HttpSession session, User user) {
        List<User> userList = userMapper.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        Result result = new Result();
        if (ServiceUtils.isReseachListOK(result, userList)) {
            session.setAttribute("user", userList.get(0));
        }
        return result;
    }


    public Result logout(HttpSession session) {
        session.removeAttribute("user");
        return new Result();
    }

    @Override
    public Result getMenus(HttpSession session, Menu menu) {
        Result result = new Result();
        User user = (User) session.getAttribute("user");
        ServiceUtils.isReseachListOK(result, menuMapper.queryByParentAndRole(menu.getParent(), user.getRole()));
        return result;
    }

    @Override
    public Map<String, Object> getMyHome(HttpSession session, Map<String, Object> map) {
        map.put("totalLaoren", laorenMapper.count());
        map.put("totalCaiji", caijiMapper.count());
        Fuwu fuwu = new Fuwu();
        fuwu.setFuwutype("服务记录");
        map.put("totalFuwuJilu", fuwuMapper.count(Example.of(fuwu)));
        fuwu.setFuwutype("服务需求");
        map.put("totalFuwuJilu", fuwuMapper.count(Example.of(fuwu)));
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
        logout.setUrl("framework/logout.do");
        map.put("logout", logout);
        return map;
    }

    @Override
    public Map<String, Object> getColumnsNameMap(HttpSession session, Map<String, Object> map, String tablename, String columns, boolean isTable) {
        if (StringUtils.isNotBlank(columns)) {
            Tableinfo tableinfo = new Tableinfo();
            tableinfo.setTablename(tablename);
            if (isTable) {
                tableinfo.setTabledisable(0);
            } else {
                tableinfo.setModaldisable(0);
            }
            map.put(columns, tableinfoMapper.findAll(Example.of(tableinfo), new Sort(Sort.Direction.ASC, "shunxu")));
        }
        return map;
    }

    @Override
    public Result getShuxings(HttpSession session, String name) {
        Result result = new Result();
        if (StringUtils.isNotBlank(name)) {
            Shuxing shuxing = new Shuxing();
            shuxing.setName(name);
            ServiceUtils.isReseachListOK(result, shuxingMapper.findAll(Example.of(shuxing), new Sort(Sort.Direction.ASC, "shunxu")));
        }
        return result;
    }

    @Override
    public Result getTableinfos(HttpSession session, String tablename, boolean notTable) {
        Result result = new Result();
        if (StringUtils.isNotBlank(tablename)) {
            Tableinfo tableinfo = new Tableinfo();
            tableinfo.setTablename(tablename);
            if (!notTable) {
                tableinfo.setTabledisable(0);
            } else {
                tableinfo.setModaldisable(0);
            }
            ServiceUtils.isReseachListOK(result, tableinfoMapper.findAll(Example.of(tableinfo, ExampleMatcher.matching().withIgnorePaths("id")), new Sort(Sort.Direction.ASC, "shunxu")));
        } else {
            ServiceUtils.isBlank(result);
        }
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
