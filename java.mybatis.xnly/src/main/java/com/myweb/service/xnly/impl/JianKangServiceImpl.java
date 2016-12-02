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
    public Result getCaiji(HttpSession session, String ids, String idType) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            Laoren laoren = laorenMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1]));
            Caiji caiji = new Caiji();
            if (idType.equals("laorenid")) {
                caiji.setLaorenid(laoren.getId());
                caiji.setLaorenname(laoren.getName());
            } else if (idType.equals("caijiid")) {
                caiji = caijiMapper.selectByPrimaryKey(Integer.parseInt(ids.split(",")[1]));
            }
            result.setData(caiji);
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result editCaiji(HttpSession session, Caiji caiji) {
        Result result = new Result();
        int count = 0;
        if (caiji.getShengao() != null && caiji.getTizhong() != null) {
            caiji.setBmi(new BigDecimal(caiji.getTizhong().longValue() / Math.pow(new Float(caiji.getShengao()) / 100, 2)));
        }
        if (caiji.getId() != null && caiji.getId() != 0) {
            count = caijiMapper.updateByPrimaryKeySelective(caiji);
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

    @Override
    public List<Caiji> getAllCaijis(HttpSession session, Caiji caiji) {
        CaijiExample example = new CaijiExample();
        CaijiExample.Criteria criteria = example.createCriteria();
        if (caiji.getLaorenid() != null) {
            criteria.andLaorenidEqualTo(caiji.getLaorenid());
        }
        return caijiMapper.selectByExample(example);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteCaiji(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isLegalIds(result, ids)) {
            result.setData(caijiMapper.deleteByPrimaryKey(Integer.parseInt(ids.split(",")[1])));
            result.setMessage("您删除了一条记录！");
        }
        return result;
    }
}
