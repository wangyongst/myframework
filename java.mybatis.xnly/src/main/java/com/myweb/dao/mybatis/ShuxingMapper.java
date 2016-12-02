package com.myweb.dao.mybatis;

import com.myweb.pojo.mybatis.Shuxing;
import com.myweb.pojo.mybatis.ShuxingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShuxingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    long countByExample(ShuxingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    int deleteByExample(ShuxingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    int insert(Shuxing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    int insertSelective(Shuxing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    List<Shuxing> selectByExample(ShuxingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    Shuxing selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    int updateByExampleSelective(@Param("record") Shuxing record, @Param("example") ShuxingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    int updateByExample(@Param("record") Shuxing record, @Param("example") ShuxingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    int updateByPrimaryKeySelective(Shuxing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shuxing
     *
     * @mbg.generated Fri Dec 02 15:44:04 CST 2016
     */
    int updateByPrimaryKey(Shuxing record);
}