package myweb.service;

import com.myweb.vo.Result;
import com.myweb.vo.mybatis.Caiji;
import com.myweb.vo.mybatis.Laoren;
import com.myweb.vo.mybatis.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface JianKangService {

    public Result getCaiji(HttpSession session, String ids, String idType);

    public Result editCaiji(HttpSession session, Caiji caiji);

    public List<Caiji> getAllCaijis(HttpSession session, Caiji caiji);

    public Result deleteCaiji(HttpSession session, String ids);
}