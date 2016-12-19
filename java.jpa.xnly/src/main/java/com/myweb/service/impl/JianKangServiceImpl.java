package com.myweb.service.impl;

import com.myweb.dao.CaijiMapper;
import com.myweb.pojo.Caiji;
import com.myweb.pojo.User;
import com.myweb.service.JianKangService;
import com.myweb.util.DateUtils;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
            ServiceUtils.isReseachOK(result, caijiMapper.getOne((Integer) result.getData()));
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
        caijiMapper.saveAndFlush(caiji);
        return ServiceUtils.isCRUDOK("create", new Result(), 1);
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateCaiji(HttpSession session, Caiji caiji) {
        if (caiji.getShengao() != null && caiji.getTizhong() != null) {
            caiji.setBmi(new BigDecimal(caiji.getTizhong().longValue() / Math.pow(new Float(caiji.getShengao()) / 100, 2)));
        }
        caijiMapper.saveAndFlush(caiji);
        return ServiceUtils.isCRUDOK("update", new Result(), 1);
    }

    @Override
    public List<Caiji> listCaijis(HttpSession session, Caiji caiji) {
        return caijiMapper.findAll(Example.of(caiji));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteCaiji(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            caijiMapper.delete((Integer) result.getData());
            return ServiceUtils.isCRUDOK("delete", result, 1);
        }
        return result;
    }
}
