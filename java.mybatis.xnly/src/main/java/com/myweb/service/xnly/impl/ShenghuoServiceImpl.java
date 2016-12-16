package com.myweb.service.xnly.impl;

import com.myweb.dao.mybatis.CaijiMapper;
import com.myweb.dao.mybatis.FuwuMapper;
import com.myweb.dao.mybatis.LaorenMapper;
import com.myweb.dao.mybatis.UserMapper;
import com.myweb.pojo.mybatis.*;
import com.myweb.service.xnly.JianKangService;
import com.myweb.service.xnly.ShenghuoService;
import com.myweb.util.DateUtils;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Service("shenghuoService")
@Transactional(value = "myTM", readOnly = true)
public class ShenghuoServiceImpl implements ShenghuoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LaorenMapper laorenMapper;

    @Autowired
    private FuwuMapper fuwuMapper;


    @Override
    public Result getFuwu(HttpSession session, String ids, String idType) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            Laoren laoren = laorenMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1]));
            Fuwu fuwu = new Fuwu();
            if (idType.equals("laorenid")) {
                fuwu.setLaorenid(laoren.getId());
                fuwu.setLaorenname(laoren.getName());
            } else if (idType.equals("fuwuid")) {
                fuwu = fuwuMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1]));
            }
            result.setData(fuwu);
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result editFuwu(HttpSession session, Fuwu fuwu) {
        Result result = new Result();
        int count = 0;
        if (fuwu.getId() != null && fuwu.getId() != 0) {
            count = fuwuMapper.updateByPrimaryKeySelective(fuwu);
        } else {
            User create = (User) session.getAttribute("user");
            fuwu.setCreateuser(create.getId());
            fuwu.setCreateusername(create.getName());
            fuwu.setCreatetime(DateUtils.getCurrentTimeSecond());
            count = fuwuMapper.insert(fuwu);
        }
        if (count != 0) {
            result.setMessage("你已成功保存一条记录！");
            return result;
        }
        result.setStatus(2);
        result.setMessage("保存失败，请联系管理员！");
        return result;
    }

    @Override
    public List<Fuwu> getAllFuwus(HttpSession session, Fuwu fuwu) {
        FuwuExample example = new FuwuExample();
        FuwuExample.Criteria criteria = example.createCriteria();
        if (fuwu.getLaorenid() != null) {
            criteria.andLaorenidEqualTo(fuwu.getLaorenid());
        }
        return fuwuMapper.selectByExample(example);
    }

    @Override
    public List<Fuwu> getAllFuwuJilus(HttpSession session, Fuwu fuwu) {
        FuwuExample example = new FuwuExample();
        FuwuExample.Criteria criteria = example.createCriteria();
        criteria.andFuwutypeEqualTo("服务记录");
        if (fuwu.getLaorenid() != null) {
            criteria.andLaorenidEqualTo(fuwu.getLaorenid());
        }
        return fuwuMapper.selectByExample(example);
    }

    @Override
    public List<Fuwu> getAllFuwuXuqius(HttpSession session, Fuwu fuwu) {
        FuwuExample example = new FuwuExample();
        FuwuExample.Criteria criteria = example.createCriteria();
        criteria.andFuwutypeEqualTo("服务需求");
        if (fuwu.getLaorenid() != null) {
            criteria.andLaorenidEqualTo(fuwu.getLaorenid());
        }
        return fuwuMapper.selectByExample(example);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteFuwu(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            result.setData(fuwuMapper.deleteByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
            result.setMessage("您删除了一条记录！");
        }
        return result;
    }
}
