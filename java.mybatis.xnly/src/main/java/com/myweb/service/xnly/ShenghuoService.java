package com.myweb.service.xnly;

import com.myweb.pojo.mybatis.Caiji;
import com.myweb.pojo.mybatis.Fuwu;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShenghuoService {

    public Result getFuwu(HttpSession session, String id);

    public Result createFuwu(HttpSession session, Fuwu fuwu);

    public Result updateFuwu(HttpSession session, Fuwu fuwu);

    public List<Fuwu> listFuwus(HttpSession session, Fuwu fuwu);

    public Result deleteFuwu(HttpSession session, String ids);
}