package com.myweb.service.impl;

import com.myweb.dao.jpa.hibernate.*;
import com.myweb.pojo.*;

import com.myweb.service.DoubleService;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service("xueXiService")
@Transactional(value = "myTM", readOnly = true)
public class DoubleServiceImpl implements DoubleService {

    @Autowired
    private HaochiRepository haochiRepository;

    @Autowired
    private ZhongjiangRepository zhongjiangRepository;


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void createHaochi(HttpSession session) {
        System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111");

        //haochiRepository.save(haochi);
    }
}
