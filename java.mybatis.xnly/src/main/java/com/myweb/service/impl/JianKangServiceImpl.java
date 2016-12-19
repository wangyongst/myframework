package com.myweb.service.impl;

import com.myweb.dao.CaijiMapper;
import com.myweb.dao.LaorenMapper;
import com.myweb.dao.UserMapper;
import com.myweb.pojo.Caiji;
import com.myweb.pojo.CaijiExample;
import com.myweb.pojo.Laoren;
import com.myweb.pojo.User;
import com.myweb.service.JianKangService;
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
    private CaijiMapper caijiMapper;


    @Override
    public Result getCaiji(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isReseachOK(result, caijiMapper.selectByPrimaryKey((Integer) result.getData()));
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
        if (caiji.getShengao() != null && caiji.getTizhong() != null) {
            caiji.setBmi(new BigDecimal(caiji.getTizhong().longValue() / Math.pow(new Float(caiji.getShengao()) / 100, 2)));
        }
        return ServiceUtils.isCRUDOK("create", new Result(), caijiMapper.insert(caiji));
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateCaiji(HttpSession session, Caiji caiji) {
        if (caiji.getShengao() != null && caiji.getTizhong() != null) {
            caiji.setBmi(new BigDecimal(caiji.getTizhong().longValue() / Math.pow(new Float(caiji.getShengao()) / 100, 2)));
        }
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
