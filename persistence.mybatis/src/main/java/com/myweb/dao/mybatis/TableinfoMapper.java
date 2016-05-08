package com.myweb.dao.mybatis;

import com.myweb.pojo.mybatis.Tableinfo;
import com.myweb.pojo.mybatis.TableinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableinfoMapper {
    int countByExample(TableinfoExample example);

    int deleteByExample(TableinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tableinfo record);

    int insertSelective(Tableinfo record);

    List<Tableinfo> selectByExample(TableinfoExample example);

    Tableinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tableinfo record, @Param("example") TableinfoExample example);

    int updateByExample(@Param("record") Tableinfo record, @Param("example") TableinfoExample example);

    int updateByPrimaryKeySelective(Tableinfo record);

    int updateByPrimaryKey(Tableinfo record);
}