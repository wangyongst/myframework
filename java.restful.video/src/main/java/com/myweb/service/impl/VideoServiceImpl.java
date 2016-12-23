package com.myweb.service.impl;

import com.myweb.dao.VideoDao;
import com.myweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("xiTongService")
@Transactional(value = "myTM", readOnly = true)
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

   }
