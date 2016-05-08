package com.myweb.dao.mybatis;

import com.myweb.pojo.mybatis.Laoren;
import com.myweb.pojo.mybatis.LaorenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LaorenMapper {
    int countByExample(LaorenExample example);

    int deleteByExample(LaorenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Laoren record);

    int insertSelective(Laoren record);

    List<Laoren> selectByExample(LaorenExample example);

    Laoren selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Laoren record, @Param("example") LaorenExample example);

    int updateByExample(@Param("record") Laoren record, @Param("example") LaorenExample example);

    int updateByPrimaryKeySelective(Laoren record);

    int updateByPrimaryKey(Laoren record);
}