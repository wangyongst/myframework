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
import java.util.TreeSet;

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
    public List<Jiashu> listJiashus(HttpSession session, Jiashu jiashu, Page page) {
        return jiashuMapper.selectByExample(null);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createJiashu(HttpSession session, Jiashu jiashu) {
        User create = (User) session.getAttribute("user");
        jiashu.setCreateuser(create.getId());
        jiashu.setCreateusername(create.getName());
        jiashu.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), jiashuMapper.insert(jiashu));
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateJiashu(HttpSession session, Jiashu jiashu) {
        return ServiceUtils.isCRUDOK("update", new Result(), jiashuMapper.updateByPrimaryKeySelective(jiashu));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateLaorenTypebyId(HttpSession session, String id, String type) {
        Result result = new Result();
        if (ServiceUtils.isIds(result, id)) {
            LaorenExample laorenExample = new LaorenExample();
            TreeSet<String> idSet = (TreeSet<String>) result.getData();
            for (String ids : idSet) {
                if (StringUtils.isNotBlank(ids)) laorenExample.or(laorenExample.createCriteria().andIdEqualTo(Integer.parseInt(ids)));
            }
            Laoren laoren = new Laoren();
            laoren.setType(Integer.parseInt(type));
            ServiceUtils.isCRUDOK("update", result, laorenMapper.updateByExampleSelective(laoren, laorenExample));
        }
        return result;
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteJiashu(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isCRUDOK("delete", result, jiashuMapper.deleteByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }


    @Override
    public Result getLaoren(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            result.setData(laorenMapper.selectByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }

    public Result getUser(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            result.setData(userMapper.selectByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }


    @Override
    public Result getJiashu(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            result.setData(jiashuMapper.selectByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createLaoren(HttpSession session, Laoren laoren) {
        User create = (User) session.getAttribute("user");
        laoren.setCreateuser(create.getId());
        laoren.setCreateusername(create.getName());
        laoren.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), laorenMapper.insert(laoren));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateLaoren(HttpSession session, Laoren laoren) {
        return ServiceUtils.isCRUDOK("update", new Result(), laorenMapper.updateByPrimaryKeySelective(laoren));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createUser(HttpSession session, User user) {
        Result result = new Result();
        if (ServiceUtils.isBlankValue(result, user.getUsername())) {
            return result;
        }
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        if (ServiceUtils.isNotUnique(result, userMapper.selectByExample(example).size())) {
            return result;
        }
        User create = (User) session.getAttribute("user");
        user.setCreateuser(create.getId());
        user.setCreateusername(create.getName());
        user.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), userMapper.insert(user));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateUser(HttpSession session, User user) {
        Result result = new Result();
        if (ServiceUtils.isBlankValue(result, user.getUsername())) {
            return result;
        }
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        example.or(example.createCriteria().andIdEqualTo(user.getId()));
        if (ServiceUtils.isNotUnique(result, userMapper.selectByExample(example).size())) {
            return result;
        }
        return ServiceUtils.isCRUDOK("update", new Result(), userMapper.updateByPrimaryKeySelective(user));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteLaoren(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            return ServiceUtils.isCRUDOK("delete", result, laorenMapper.deleteByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteUser(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            return ServiceUtils.isCRUDOK("delete", result, userMapper.deleteByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }
}
