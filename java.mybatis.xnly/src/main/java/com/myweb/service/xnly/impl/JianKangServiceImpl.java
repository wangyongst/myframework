package com.myweb.service.xnly.impl;

import com.myweb.dao.mybatis.CaijiMapper;
import com.myweb.dao.mybatis.LaorenMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.pojo.mybatis.Caiji;
import com.myweb.pojo.mybatis.CaijiExample;
import com.myweb.pojo.mybatis.Laoren;
import com.myweb.pojo.mybatis.User;
import com.myweb.service.xnly.JianKangService;
import com.myweb.util.DateUtils;
import com.myweb.util.ServiceUtils;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Service("jianKangService")
@Transactional(value = "myTM", readOnly = true)
public class JianKangServiceImpl implements JianKangService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LaorenMapper laorenMapper;

    @Autowired
    private CaijiMapper caijiMapper;


    @Override
    public Result getCaiji(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            result.setData(caijiMapper.selectByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createCaiji(HttpSession session, Caiji caiji) {
        User create = (User) session.getAttribute("user");
        caiji.setCreateuser(create.getId());
        caiji.setCreateusername(create.getName());
        caiji.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), caijiMapper.insert(caiji));
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateCaiji(HttpSession session, Caiji caiji) {
        return ServiceUtils.isCRUDOK("update", new Result(), caijiMapper.updateByPrimaryKeySelective(caiji));
    }

    @Override
    public List<Caiji> listCaijis(HttpSession session, Caiji caiji) {
        CaijiExample example = new CaijiExample();
        CaijiExample.Criteria criteria = example.createCriteria();
        if (caiji.getLaorenid() != null) {
            criteria.andLaorenidEqualTo(caiji.getLaorenid());
        }
        return caijiMapper.selectByExample(example);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteCaiji(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            return ServiceUtils.isCRUDOK("delete", result, caijiMapper.deleteByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }
}
