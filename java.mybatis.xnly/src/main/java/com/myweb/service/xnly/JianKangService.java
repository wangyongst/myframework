package com.myweb.service.xnly;

import com.myweb.util.Result;
import com.myweb.pojo.mybatis.Caiji;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface JianKangService {

    public Result getCaiji(HttpSession session, String id);

    public Result createCaiji(HttpSession session, Caiji caiji);

    public Result updateCaiji(HttpSession session, Caiji caiji);

    public List<Caiji> listCaijis(HttpSession session, Caiji caiji);

    public Result deleteCaiji(HttpSession session, String ids);
}