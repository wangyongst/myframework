package com.myweb.service.impl;

import com.myweb.dao.FrameWorkDao;
import com.myweb.pojo.User;
import com.myweb.service.FrameWorkService;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("frameWorkService")
@Transactional(value = "myTM", readOnly = true)
public class FrameWorkServiceImpl implements FrameWorkService {

    @Autowired
    private FrameWorkDao frameWorkDao;

    @Override
    public Result login(HttpSession session, User user) {
        List<User> userList = frameWorkDao.findUsersByUsernameAndPassword(user.getUsername(), user.getPassword());
        Result result = new Result();
        if (ServiceUtils.isReseachListOK(result, userList)) {
            session.setAttribute("user", userList.get(0));
        }
        return result;
    }
}
