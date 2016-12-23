package com.myweb.dao;


import com.myweb.pojo.Password;
import com.myweb.pojo.Video;

import java.util.List;

public interface VideoDao {

    public void saveVideo(Video video);

    public List<Password> findPasswordbyPassword(String password);
}
