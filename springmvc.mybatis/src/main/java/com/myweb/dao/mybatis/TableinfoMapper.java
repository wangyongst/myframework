package com.myweb.dao.mybatis;

import com.myweb.vo.mybatis.Tableinfo;
import com.myweb.vo.mybatis.TableinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int countByExample(TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int deleteByExample(TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int insert(Tableinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int insertSelective(Tableinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    List<Tableinfo> selectByExample(TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    Tableinfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int updateByExampleSelective(@Param("record") Tableinfo record, @Param("example") TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int updateByExample(@Param("record") Tableinfo record, @Param("example") TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int updateByPrimaryKeySelective(Tableinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbggenerated Tue May 03 21:51:50 CST 2016
     */
    int updateByPrimaryKey(Tableinfo record);
}