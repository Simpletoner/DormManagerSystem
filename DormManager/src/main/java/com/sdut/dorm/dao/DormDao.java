package com.sdut.dorm.dao;

import com.sdut.dorm.bean.Dorm;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DormDao {
    @Select("select * from dorm where room_count>0 and state=1")
    List<Dorm> getNotFullDorm();

    @Select("select * from dorm")
    List<Dorm> getAll();

    @Select("select * from dorm where dorm_num=#{dormNum}")
    Dorm getById(String dormNum);

    @Insert("insert into dorm (dorm_name,dorm_num,beds_num,dorm_type,room_count,dorm_gender,dorm_floor,dorm_group) values " +
            "(#{dorm.dormName},#{dorm.dormNum},#{dorm.bedsNum},#{dorm.dormType},#{dorm.roomCount},#{dorm.dormGender},#{dorm.dormFloor},#{dorm.dormGroup})")
    void insert(@Param("dorm")Dorm dorm);

    @Delete("delete from dorm where dorm_num=#{dormNum}")
    void delete(String dormNum);


}
