package com.myweb.service.xnly;

import com.myweb.util.Result;
import com.myweb.pojo.mybatis.Caiji;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface JianKangService {

    Result getCaiji(HttpSession session, String id);

    Result createCaiji(HttpSession session, Caiji caiji);

    Result updateCaiji(HttpSession session, Caiji caiji);

    List<Caiji> listCaijis(HttpSession session, Caiji caiji);

    Result deleteCaiji(HttpSession session, String ids);
}