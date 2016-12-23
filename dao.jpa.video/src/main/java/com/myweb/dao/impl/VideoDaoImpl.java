package com.myweb.dao.impl;

import com.myweb.dao.VideoDao;
import com.myweb.dao.jpa.hibernate.PasswordRepository;
import com.myweb.dao.jpa.hibernate.VideoRepository;
import com.myweb.pojo.Password;
import com.myweb.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("videoDao")
class VideoDaoImpl implements VideoDao {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Override
    public void saveVideo(Video video) {
        videoRepository.saveAndFlush(video);
    }

    public List<Password> findPasswordbyPassword(String password) {
        return passwordRepository.findByPassword(password);
    }
}
