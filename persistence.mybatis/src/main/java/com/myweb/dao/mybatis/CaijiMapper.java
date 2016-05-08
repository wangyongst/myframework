package com.myweb.dao.mybatis;

import com.myweb.pojo.mybatis.Caiji;
import com.myweb.pojo.mybatis.CaijiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaijiMapper {
    int countByExample(CaijiExample example);

    int deleteByExample(CaijiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Caiji record);

    int insertSelective(Caiji record);

    List<Caiji> selectByExample(CaijiExample example);

    Caiji selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Caiji record, @Param("example") CaijiExample example);

    int updateByExample(@Param("record") Caiji record, @Param("example") CaijiExample example);

    int updateByPrimaryKeySelective(Caiji record);

    int updateByPrimaryKey(Caiji record);
}