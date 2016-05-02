package com.myweb.service.impl;

import com.myweb.dao.mybatis.RenyuanMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.service.XiTongService;
import com.myweb.vo.Result;
import com.myweb.vo.mybatis.Renyuan;
import com.myweb.vo.mybatis.User;
import com.myweb.vo.mybatis.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("xiTongService")
@Transactional
public class XiTongServiceImpl implements XiTongService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RenyuanMapper renyuanMapper;


    public List<User> getAllUsers(HttpSession session) {
        return userMapper.selectByExample(null);
    }

    public List<Renyuan> getAllRenyuans(HttpSession session) {
        return renyuanMapper.selectByExample(null);
    }

    public Result getRenyuan(HttpSession session, String ids) {
        Result result = new Result();
        if (ids == null || ids.equals("")) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length == 2) {
                result.setStatus(1);
                result.setData(renyuanMapper.selectByPrimaryKey(Integer.parseInt(ida[1])));
            } else {
                result.setStatus(3);
                result.setMessage("您选择了多条记录，请选择一条记录！");
            }
        }
        return result;
    }

    public Result getUser(HttpSession session, String ids) {
        Result result = new Result();
        if (ids == null || ids.equals("")) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length == 2) {
                result.setStatus(1);
                result.setData(userMapper.selectByPrimaryKey(Integer.parseInt(ida[1])));
            } else {
                result.setStatus(3);
                result.setMessage("您选择了多条记录，请选择一条记录！");
            }
        }
        return result;
    }

    public Result editRenyuan(HttpSession session, Renyuan renyuan) {
        Result result = new Result();
        int count = 0;
        if (renyuan.getId() != null && renyuan.getId() != 0) {
            count = renyuanMapper.updateByPrimaryKey(renyuan);
        } else {
            count = renyuanMapper.insert(renyuan);
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

    public Result editUser(HttpSession session, User user) {
        Result result = new Result();
        int count = 0;
        if (user.getUsername() == null || user.getUsername().equals("") || user.getPassword() == null || user.getPassword().equals("")) {
            result.setStatus(3);
            result.setMessage("用户名或密码不能为空！");
            return result;
        }
        if (user.getId() != null && user.getId() != 0) {
            count = userMapper.updateByPrimaryKey(user);
        } else {
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername());
            if (userMapper.selectByExample(example).size() > 1) {
                result.setStatus(4);
                result.setMessage("用户名已经存在，请使用新的用户名！");
                return result;
            }
            count = userMapper.insert(user);
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

    public Result deleteRenyuan(HttpSession session, String ids) {
        Result result = new Result();
        if (ids == null || ids.equals("")) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length == 2) {
                result.setStatus(1);
                result.setData(renyuanMapper.deleteByPrimaryKey(Integer.parseInt(ida[1])));
                result.setMessage("您删除了一条记录！");
            } else {
                result.setStatus(3);
                result.setMessage("您选择了多条记录，请选择一条记录！");
            }
        }
        return result;
    }


    public Result deleteUser(HttpSession session, String ids) {
        Result result = new Result();
        if (ids == null || ids.equals("")) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length == 2) {
                result.setStatus(1);
                result.setData(userMapper.deleteByPrimaryKey(Integer.parseInt(ida[1])));
                result.setMessage("您删除了一条记录！");
            } else {
                result.setStatus(3);
                result.setMessage("您选择了多条记录，请选择一条记录！");
            }
        }
        return result;
    }

}
