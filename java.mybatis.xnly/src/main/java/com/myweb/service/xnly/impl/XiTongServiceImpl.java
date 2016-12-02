package com.myweb.service.xnly.impl;

import com.myweb.dao.mybatis.JiashuMapper;
import com.myweb.dao.mybatis.LaorenMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.pojo.mybatis.*;
import com.myweb.service.xnly.XiTongService;
import com.myweb.util.DateUtils;
import com.myweb.util.ServiceUtils;
import com.myweb.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
    public List<User> getAllUsers(HttpSession session) {
        return userMapper.selectByExample(null);
    }

    @Override
    public List<Laoren> getAllLaorens(HttpSession session) {
        return laorenMapper.selectByExample(null);
    }

    @Override
    public List<Jiashu> getAllJiashus(HttpSession session) {
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
        if (ServiceUtils.isOnlyOne(result, ids)) {
            result.setData(jiashuMapper.deleteByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
            result.setMessage("您删除了一条记录！");
        }
        return result;
    }

    @Override
    public List<Laoren> getDSRLaorens(HttpSession session) {
        LaorenExample example = new LaorenExample();
        LaorenExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(1);
        return laorenMapper.selectByExample(example);
    }

    @Override
    public List<Laoren> getYMJLaorens(HttpSession session) {
        LaorenExample example = new LaorenExample();
        LaorenExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(2);
        return laorenMapper.selectByExample(example);
    }

    @Override
    public List<Laoren> getOtherLaorens(HttpSession session) {
        LaorenExample example = new LaorenExample();
        LaorenExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIsNull();
        return laorenMapper.selectByExample(example);
    }

    @Override
    public Result getLaoren(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOne(result, ids)) {
            result.setData(laorenMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
        }
        return result;
    }

    public Result getUser(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOne(result, ids)) {
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
        if (ServiceUtils.isOnlyOne(result, ids)) {
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
    public Result editDSRLaoren(HttpSession session, Laoren laoren) {
        Result result = new Result();
        int count = 0;
        laoren.setType(1);
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
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result editYMJLaoren(HttpSession session, Laoren laoren) {
        Result result = new Result();
        int count = 0;
        laoren.setType(2);
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
        if (ServiceUtils.isOnlyOne(result, ids)) {
            result.setData(laorenMapper.deleteByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
            result.setMessage("您删除了一条记录！");
        }
        return result;
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result changeLaoren(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOne(result, ids)) {
            Laoren laoren = laorenMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1]));
            if(laoren.getType() == null){
                laoren.setType(1);
            }else{
                laoren.setType(null);
            }
            result.setData(laorenMapper.updateByPrimaryKey(laoren));
            result.setMessage("您移动了一条记录！");
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteUser(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOne(result, ids)) {
            result.setData(userMapper.deleteByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
            result.setMessage("您删除了一条记录！");
        }
        return result;
    }
}
