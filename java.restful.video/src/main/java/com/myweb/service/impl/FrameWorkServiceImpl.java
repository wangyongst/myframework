package com.myweb.service.impl;

import com.myweb.dao.FrameWorkDao;
import com.myweb.pojo.Platform;
import com.myweb.pojo.User;
import com.myweb.pojo.Video;
import com.myweb.service.FrameWorkService;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("frameWorkService")
@Transactional(value = "myTM", readOnly = true)
public class FrameWorkServiceImpl implements FrameWorkService {

    @Autowired
    private FrameWorkDao frameWorkDao;

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result playVideo(String platformid, String url, String password) {
        Result result = new Result();
        Video video = new Video();
        video.setUrl(url);
        if (url != null && frameWorkDao.findVideoByUrl(url).size() == 0) {
            frameWorkDao.saveVideo(video);
        }
        ServiceUtils.isReseachListOK(result, frameWorkDao.findPasswordByPassword(password));
        if (result.getStatus() != 1) return result;
        Platform platform = frameWorkDao.findPlatformById(Integer.parseInt(platformid));
        result.setData(platform.getUrl() + url);
        return result;
    }

    @Override
    public Result login(HttpSession session, User user) {
        List<User> userList = frameWorkDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        Result result = new Result();
        if (ServiceUtils.isReseachListOK(result, userList)) {
            session.setAttribute("user", userList.get(0));
        }
        return result;
    }
}
