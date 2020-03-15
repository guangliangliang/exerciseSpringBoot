package com.testkshdata.dci.testdata.mapper;

import com.testkshdata.dci.testdata.pojo.MainLayers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainLayersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table main_layers
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer layerid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table main_layers
     *
     * @mbggenerated
     */
    int insert(MainLayers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table main_layers
     *
     * @mbggenerated
     */
    int insertSelective(MainLayers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table main_layers
     *
     * @mbggenerated
     */
    MainLayers selectByPrimaryKey(Integer layerid);



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table main_layers
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MainLayers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table main_layers
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MainLayers record);
}