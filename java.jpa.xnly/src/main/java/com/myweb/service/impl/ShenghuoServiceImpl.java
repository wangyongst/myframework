package com.myweb.service.impl;

import com.myweb.dao.FuwuMapper;
import com.myweb.pojo.Fuwu;
import com.myweb.pojo.User;
import com.myweb.service.ShenghuoService;
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
            ServiceUtils.isReseachOK(result, fuwuMapper.getOne((Integer) result.getData()));
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
        fuwuMapper.saveAndFlush(fuwu);
        return ServiceUtils.isCRUDOK("create", new Result(), 1);
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateFuwu(HttpSession session, Fuwu fuwu) {
        fuwuMapper.saveAndFlush(fuwu);
        return ServiceUtils.isCRUDOK("update", new Result(), 1);
    }

    @Override
    public List<Fuwu> listFuwus(HttpSession session, Fuwu fuwu) {
        return fuwuMapper.findAll(Example.of(fuwu));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteFuwu(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, ids)) {
            fuwuMapper.delete((Integer) result.getData());
            return ServiceUtils.isCRUDOK("delete", result, 1);
        }
        return result;
    }
}
