package com.myweb.service.impl;

import com.myweb.dao.mybatis.CaijiMapper;
import com.myweb.dao.mybatis.LaorenMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.service.JianKangService;
import com.myweb.util.DateUtils;
import com.myweb.vo.Result;
import com.myweb.vo.mybatis.Caiji;
import com.myweb.vo.mybatis.Laoren;
import com.myweb.vo.mybatis.User;
import com.myweb.vo.mybatis.UserExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("jiKangService")
@Transactional
public class JianKangServiceImpl implements JianKangService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LaorenMapper laorenMapper;

    @Autowired
    private CaijiMapper caijiMapper;


    @Override
    public Result getCaiji(HttpSession session, String ids) {
        Result result = new Result();
        if (StringUtils.isBlank(ids)) {
            result.setStatus(0);
            result.setMessage("请先选择一条记录！");
        } else {
            String[] ida = ids.split(",");
            if (ida.length == 2) {
                result.setStatus(1);
                result.setData(userMapper.selectByPrimaryKey(Integer.parseInt(ida[1])));
                result.setMessage(ida[1]);
            } else {
                result.setStatus(3);
                result.setMessage("您选择了多条记录，请选择一条记录！");
            }
        }
        return result;
    }

    @Override
    public Result editCaiji(HttpSession session, Caiji caiji) {
        Result result = new Result();
        int count = 0;
        if (caiji.getId() != null && caiji.getId() != 0) {
            count = caijiMapper.updateByPrimaryKey(caiji);
        } else {
            User create = (User) session.getAttribute("user");
            caiji.setCreateuser(create.getId());
            caiji.setCreateusername(create.getName());
            caiji.setCreatetime(DateUtils.getCurrentTimeSecond());
            count = caijiMapper.insert(caiji);
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
}
