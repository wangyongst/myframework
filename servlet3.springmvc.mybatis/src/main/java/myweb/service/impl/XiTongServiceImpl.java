package myweb.service.impl;

import com.myweb.dao.mybatis.LaorenMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.service.XiTongService;
import com.myweb.util.DateUtils;
import com.myweb.vo.Result;
import com.myweb.vo.mybatis.Laoren;
import com.myweb.vo.mybatis.User;
import com.myweb.vo.mybatis.UserExample;
import org.apache.commons.lang3.StringUtils;
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
    private LaorenMapper laorenMapper;


    public List<User> getAllUsers(HttpSession session) {
        return userMapper.selectByExample(null);
    }

    public List<Laoren> getAllLaorens(HttpSession session) {
        return laorenMapper.selectByExample(null);
    }

    public Result getLaoren(HttpSession session, String ids) {
        Result result = new Result();
        if (StringUtils.isBlank(ids)) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length == 2) {
                result.setStatus(1);
                result.setData(laorenMapper.selectByPrimaryKey(Integer.parseInt(ida[1])));
            } else {
                result.setStatus(3);
                result.setMessage("您选择了多条记录，请选择一条记录！");
            }
        }
        return result;
    }

    public Result getUser(HttpSession session, String ids) {
        Result result = new Result();
        if (StringUtils.isBlank(ids)) {
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

    public Result deleteLaoren(HttpSession session, String ids) {
        Result result = new Result();
        if (StringUtils.isBlank(ids)) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length == 2) {
                result.setStatus(1);
                result.setData(laorenMapper.deleteByPrimaryKey(Integer.parseInt(ida[1])));
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
        if (StringUtils.isBlank(ids)) {
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
