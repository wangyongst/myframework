package com.myweb.service.impl;

import com.myweb.dao.VideoDao;
import com.myweb.pojo.Video;
import com.myweb.service.VideoService;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("videoService")
@Transactional(value = "myTM", readOnly = true)
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result playVideo(String url, String password) {
        Result result = new Result();
        Video video = new Video();
        video.setUrl(url);
        videoDao.saveVideo(video);
        ServiceUtils.isReseachListOK(result, videoDao.findPasswordbyPassword(password));
        if (result.getStatus() != 1) return result;
        result.setData("http://jx.71ki.com/?url=" + url);
        return result;
    }
}
