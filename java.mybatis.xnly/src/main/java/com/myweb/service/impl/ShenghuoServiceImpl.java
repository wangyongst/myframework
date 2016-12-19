package com.myweb.service.impl;

import com.myweb.dao.FuwuMapper;
import com.myweb.pojo.Fuwu;
import com.myweb.pojo.FuwuExample;
import com.myweb.pojo.User;
import com.myweb.service.ShenghuoService;
import com.myweb.util.DateUtils;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("shenghuoService")
@Transactional(value = "myTM", readOnly = true)
public class ShenghuoServiceImpl implements ShenghuoService {

    @Autowired
    private FuwuMapper fuwuMapper;


    @Override
    public Result getFuwu(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, ids)) {
            ServiceUtils.isReseachOK(result, fuwuMapper.selectByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createFuwu(HttpSession session, Fuwu fuwu) {
        Result result = new Result();

        User create = (User) session.getAttribute("user");
        fuwu.setCreateuser(create.getId());
        fuwu.setCreateusername(create.getName());
        fuwu.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), fuwuMapper.insert(fuwu));
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateFuwu(HttpSession session, Fuwu fuwu) {
        return ServiceUtils.isCRUDOK("update", new Result(), fuwuMapper.updateByPrimaryKeySelective(fuwu));
    }

    @Override
    public List<Fuwu> listFuwus(HttpSession session, Fuwu fuwu) {
        FuwuExample example = new FuwuExample();
        FuwuExample.Criteria criteria = example.createCriteria();
        if (fuwu.getLaorenid() != null) {
            criteria.andLaorenidEqualTo(fuwu.getLaorenid());
        }
        criteria.andFuwutypeEqualTo(fuwu.getFuwutype());
        return fuwuMapper.selectByExample(example);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteFuwu(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, ids)) {
            return ServiceUtils.isCRUDOK("delete", result, fuwuMapper.deleteByPrimaryKey((Integer) result.getData()));
        }
        return result;
    }
}
