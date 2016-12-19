package com.myweb.service.xnly;

import com.myweb.pojo.*;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShenghuoService {

    Result getFuwu(HttpSession session, String id);

    Result createFuwu(HttpSession session, Fuwu fuwu);

    Result updateFuwu(HttpSession session, Fuwu fuwu);

    List<Fuwu> listFuwus(HttpSession session, Fuwu fuwu);

    Result deleteFuwu(HttpSession session, String ids);
}