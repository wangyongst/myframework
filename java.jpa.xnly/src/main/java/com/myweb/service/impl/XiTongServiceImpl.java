package com.myweb.service.impl;

import com.myweb.dao.JiashuMapper;
import com.myweb.dao.LaorenMapper;
import com.myweb.dao.UserMapper;
import com.myweb.pojo.Jiashu;
import com.myweb.pojo.Laoren;
import com.myweb.pojo.User;
import com.myweb.service.XiTongService;
import com.myweb.util.DateUtils;
import com.myweb.util.Page;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        return userMapper.findByUsernameNot("super");
    }

    @Override
    public List<Laoren> listLaorens(HttpSession session, Laoren laoren, Page page) {
        return laorenMapper.findAll(Example.of(laoren));
    }

    @Override
    public List<Jiashu> listJiashus(HttpSession session, Jiashu jiashu, Page page) {
        return jiashuMapper.findAll();
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createJiashu(HttpSession session, Jiashu jiashu) {
        User create = (User) session.getAttribute("user");
        jiashu.setCreateuser(create.getId());
        jiashu.setCreateusername(create.getName());
        jiashu.setCreatetime(DateUtils.getCurrentTimeSecond());
        jiashuMapper.saveAndFlush(jiashu);
        return ServiceUtils.isCRUDOK("create", new Result(), 1);
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateJiashu(HttpSession session, Jiashu jiashu) {
        jiashuMapper.saveAndFlush(jiashu);
        return ServiceUtils.isCRUDOK("update", new Result(), 1);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateLaorenTypebyId(HttpSession session, String id, String type) {
        Result result = new Result();
        Laoren laoren = new Laoren();
        laoren.setType(Integer.parseInt(type));
        int count = 0;
        if (ServiceUtils.isIds(result, id)) {
            TreeSet<String> idSet = (TreeSet<String>) result.getData();
            for (String ids : idSet) {
                if (StringUtils.isNotBlank(ids)) laorenMapper.saveAndFlush(laoren);
                count++;
            }
            ServiceUtils.isCRUDOK("update", result, count);
        }
        return result;
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteJiashu(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            jiashuMapper.delete((Integer) result.getData());
            ServiceUtils.isCRUDOK("delete", result, 1);
        }
        return result;
    }


    @Override
    public Result getLaoren(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isReseachOK(result, laorenMapper.getOne((Integer) result.getData()));
        }
        return result;
    }

    public Result getUser(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isReseachOK(result, userMapper.getOne((Integer) result.getData()));
        }
        return result;
    }


    @Override
    public Result getJiashu(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isReseachOK(result, jiashuMapper.getOne((Integer) result.getData()));
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
        laorenMapper.saveAndFlush(laoren);
        return ServiceUtils.isCRUDOK("create", new Result(), 1);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateLaoren(HttpSession session, Laoren laoren) {
        laorenMapper.saveAndFlush(laoren);
        return ServiceUtils.isCRUDOK("update", new Result(), 1);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createUser(HttpSession session, User user) {
        Result result = new Result();
        if (ServiceUtils.isBlankValue(result, user.getUsername())) {
            return result;
        }
        if (ServiceUtils.isNotUnique(result, userMapper.findAll(Example.of(user)).size())) {
            return result;
        }
        User create = (User) session.getAttribute("user");
        user.setCreateuser(create.getId());
        user.setCreateusername(create.getName());
        user.setCreatetime(DateUtils.getCurrentTimeSecond());
        userMapper.saveAndFlush(user);
        return ServiceUtils.isCRUDOK("create", new Result(), 1);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateUser(HttpSession session, User user) {
        Result result = new Result();
        if (ServiceUtils.isBlankValue(result, user.getUsername())) {
            return result;
        }
        if (ServiceUtils.isNotUnique(result, userMapper.findByUsernameAndIdNot(user.getUsername(), user.getId()).size())) {
            return result;
        }
        userMapper.saveAndFlush(user);
        return ServiceUtils.isCRUDOK("update", new Result(), 1);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteLaoren(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            laorenMapper.delete((Integer) result.getData());
            return ServiceUtils.isCRUDOK("delete", result, 1);
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteUser(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            userMapper.delete((Integer) result.getData());
            return ServiceUtils.isCRUDOK("delete", result, 1);
        }
        return result;
    }
}
