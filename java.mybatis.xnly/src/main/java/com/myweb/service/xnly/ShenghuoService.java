package com.myweb.service.xnly;

import com.myweb.pojo.mybatis.Caiji;
import com.myweb.pojo.mybatis.Fuwu;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShenghuoService {

    public Result getFuwu(HttpSession session, String ids, String idType);

    public Result editFuwu(HttpSession session, Fuwu fuwu);

    public List<Fuwu> getAllFuwus(HttpSession session, Fuwu fuwu);

    public List<Fuwu> getAllFuwuJilus(HttpSession session, Fuwu fuwu);

    public List<Fuwu> getAllFuwuXuqius(HttpSession session, Fuwu fuwu);

    public Result deleteFuwu(HttpSession session, String ids);
}