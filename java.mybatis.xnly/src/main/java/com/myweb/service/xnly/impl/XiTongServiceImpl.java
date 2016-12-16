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
    public List<Laoren> listLaorens(HttpSession session, Laoren laoren, Page page) {
        LaorenExample example = new LaorenExample();
        if (laoren.getType() != null) example.createCriteria().andTypeEqualTo(laoren.getType());
        return laorenMapper.selectByExample(example);
    }

    @Override
    public List<Jiashu> listLaorenJiashus(HttpSession session, Jiashu jiashu, Page page) {
        return jiashuMapper.selectByExample(null);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result saveOrUpdateJiashu(HttpSession session, Jiashu jiashu) {
        Result result = new Result();
        if (jiashu.getId() != null && jiashu.getId() != 0) {
            ServiceUtils.isUpdateOK(result, jiashuMapper.updateByPrimaryKeySelective(jiashu));
        } else {
            User create = (User) session.getAttribute("user");
            jiashu.setCreateuser(create.getId());
            jiashu.setCreateusername(create.getName());
            jiashu.setCreatetime(DateUtils.getCurrentTimeSecond());
            ServiceUtils.isSaveOK(result, jiashuMapper.insert(jiashu));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteJiashu(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, id)) {
            ServiceUtils.isDeleteOK(result, jiashuMapper.deleteByPrimaryKey(Integer.parseInt((String) result.getData())));
        }
        return result;
    }


    @Override
    public Result getLaoren(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, id)) {
            result.setData(laorenMapper.selectByPrimaryKey(Integer.parseInt(id)));
        }
        return result;
    }

    public Result getUser(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, id)) {
            result.setData(userMapper.selectByPrimaryKey(Integer.parseInt((String) result.getData())));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result saveOrUpdateLaoren(HttpSession session, Laoren laoren) {
        Result result = new Result();
        int count = 0;
        if (laoren.getId() != null && laoren.getId() != 0) {
            ServiceUtils.isUpdateOK(result, laorenMapper.updateByPrimaryKey(laoren));
        } else {
            User create = (User) session.getAttribute("user");
            laoren.setCreateuser(create.getId());
            laoren.setCreateusername(create.getName());
            laoren.setCreatetime(DateUtils.getCurrentTimeSecond());
            ServiceUtils.isSaveOK(result, laorenMapper.insert(laoren));
        }

        return result;
    }

    @Override
    public Result getJiashu(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, id)) {
            result.setData(jiashuMapper.selectByPrimaryKey(Integer.parseInt((String) result.getData())));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result saveOrUpdateUser(HttpSession session, User user) {
        Result result = new Result();
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            result.setStatus(3);
            result.setMessage("用户名或密码不能为空！");
            return result;
        }
        if (user.getId() != null && user.getId() != 0) {
            ServiceUtils.isUpdateOK(result, userMapper.updateByPrimaryKeySelective(user));
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
                ServiceUtils.isSaveOK(result, userMapper.insert(user));
            }
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteLaoren(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, id)) {
            ServiceUtils.isDeleteOK(result, laorenMapper.deleteByPrimaryKey(Integer.parseInt((String) result.getData())));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteUser(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, id)) {
            ServiceUtils.isDeleteOK(result, userMapper.deleteByPrimaryKey(Integer.parseInt((String) result.getData())));
        }
        return result;
    }
}
