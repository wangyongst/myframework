package com.myweb.service.xnly.impl;

import com.myweb.dao.mybatis.JiashuMapper;
import com.myweb.dao.mybatis.LaorenMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.pojo.mybatis.*;
import com.myweb.service.xnly.XiTongService;
import com.myweb.util.DateUtils;
import com.myweb.util.Page;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("xiTongService")
@Transactional(value = "myTM", readOnly = true)
public class XiTongServiceImpl implements XiTongService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LaorenMapper laorenMapper;

    @Autowired
    private JiashuMapper jiashuMapper;

    @Override
    public List<User> listUsers(HttpSession session, User user, Page page) {
        UserExample userExapmle = new UserExample();
        userExapmle.createCriteria().andUsernameNotEqualTo("super");
        return userMapper.selectByExample(userExapmle);
    }

    @Override
    public List<Laoren> listLaorens(HttpSession session, Laoren laoren) {
        LaorenExample example = new LaorenExample();
        if (laoren.getType() != null) example.createCriteria().andTypeEqualTo(laoren.getType());
        return laorenMapper.selectByExample(example);
    }

    @Override
    public List<Jiashu> listLaorenJiashus(HttpSession session) {
        return jiashuMapper.selectByExample(null);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result editJiashu(HttpSession session, Jiashu jiashu) {
        Result result = new Result();
        int count = 0;
        if (jiashu.getId() != null && jiashu.getId() != 0) {
            count = jiashuMapper.updateByPrimaryKeySelective(jiashu);
        } else {
            User create = (User) session.getAttribute("user");
            jiashu.setCreateuser(create.getId());
            jiashu.setCreateusername(create.getName());
            jiashu.setCreatetime(DateUtils.getCurrentTimeSecond());
            count = jiashuMapper.insert(jiashu);
        }
        if (count != 0) {
            result.setStatus(1);
            result.setMessage("你已成功保存一条记录！");
            return result;
        }
        result.setStatus(2);
        result.setMessage("保存失败，请联系管理员！");
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteJiashu(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            result.setData(jiashuMapper.deleteByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
            result.setMessage("您删除了一条记录！");
        }
        return result;
    }


    @Override
    public Result getLaoren(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            result.setData(laorenMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
        }
        return result;
    }

    public Result getUser(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            result.setData(userMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result editLaoren(HttpSession session, Laoren laoren) {
        Result result = new Result();
        int count = 0;
        if (laoren.getId() != null && laoren.getId() != 0) {
            count = laorenMapper.updateByPrimaryKey(laoren);
        } else {
            User create = (User) session.getAttribute("user");
            laoren.setCreateuser(create.getId());
            laoren.setCreateusername(create.getName());
            laoren.setCreatetime(DateUtils.getCurrentTimeSecond());
            count = laorenMapper.insert(laoren);
        }
        if (count != 0) {
            result.setStatus(1);
            result.setMessage("你已成功保存一条记录！");
            return result;
        }
        result.setStatus(2);
        result.setMessage("保存失败，请联系管理员！");
        return result;
    }

    @Override
    public Result getJiashu(HttpSession session, String ids, String idType) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            Jiashu jiashu = new Jiashu();
            Laoren laoren = laorenMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1]));
            if (idType.equals("laorenid")) {
                jiashu.setLaorenid(laoren.getId());
                jiashu.setLaorenname(laoren.getName());
            } else if (idType.equals("jiashuid")) {
                jiashu = jiashuMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1]));
            }
            result.setData(jiashu);
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result editUser(HttpSession session, User user) {
        Result result = new Result();
        int count = 0;
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            result.setStatus(3);
            result.setMessage("用户名或密码不能为空！");
            return result;
        }
        if (user.getId() != null && user.getId() != 0) {
            count = userMapper.updateByPrimaryKeySelective(user);
        } else {
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername());
            if (userMapper.selectByExample(example).size() > 1) {
                result.setStatus(4);
                result.setMessage("用户名已经存在，请使用新的用户名！");
                return result;
            } else {
                User create = (User) session.getAttribute("user");
                user.setCreateuser(create.getId());
                user.setCreateusername(create.getName());
                user.setCreatetime(DateUtils.getCurrentTimeSecond());
                count = userMapper.insert(user);
            }
        }
        if (count != 0) {
            result.setStatus(1);
            result.setMessage("你已成功保存一条记录！");
            return result;
        }
        result.setStatus(2);
        result.setMessage("保存失败，请联系管理员！");
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteLaoren(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            result.setData(laorenMapper.deleteByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
            result.setMessage("您删除了一条记录！");
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteUser(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            result.setData(userMapper.deleteByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
            result.setMessage("您删除了一条记录！");
        }
        return result;
    }
}
