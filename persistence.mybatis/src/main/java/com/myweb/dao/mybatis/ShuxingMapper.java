package com.myweb.dao.mybatis;

import com.myweb.pojo.mybatis.Shuxing;
import com.myweb.pojo.mybatis.ShuxingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShuxingMapper {
    int countByExample(ShuxingExample example);

    int deleteByExample(ShuxingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shuxing record);

    int insertSelective(Shuxing record);

    List<Shuxing> selectByExample(ShuxingExample example);

    Shuxing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shuxing record, @Param("example") ShuxingExample example);

    int updateByExample(@Param("record") Shuxing record, @Param("example") ShuxingExample example);

    int updateByPrimaryKeySelective(Shuxing record);

    int updateByPrimaryKey(Shuxing record);
}