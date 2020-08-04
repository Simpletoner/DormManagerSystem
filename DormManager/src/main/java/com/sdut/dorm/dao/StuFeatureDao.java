package com.sdut.dorm.dao;

import com.sdut.dorm.bean.StuFeature;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuFeatureDao {
    @Select("select * from stu_feature")
    List<StuFeature> getAll();

    @Select("select * from stu_feature where stu_num=#{stuNum}")
    StuFeature getById(String stuNum);

    @Insert("insert into stu_feature (stu_num,get_up_time,sleep_time,afternoon,nature,sport,game,literature,music,sanitation,cost,source,residence) values " +
            "(#{stuFeature.stuNum},#{stuFeature.getUpTime},#{stuFeature.sleepTime},#{stuFeature.afternoon},#{stuFeature.nature},#{stuFeature.sport},#{stuFeature.game},#{stuFeature.literature},#{stuFeature.music},#{stuFeature.sanitation},#{stuFeature.cost},#{stuFeature.source},#{stuFeature.residence})")
    void insert(@Param("stuFeature") StuFeature stuFeature);

}
