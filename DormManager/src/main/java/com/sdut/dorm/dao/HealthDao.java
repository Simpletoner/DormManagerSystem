package com.sdut.dorm.dao;

import com.sdut.dorm.bean.Health;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface HealthDao {
    @Select("select * from health_score")
    public List<Health> getAll();

    @Select("select * from health_score where id=#{id}")
    public Health getHealthById(Integer id);

    @Insert("insert into health_score (score_num,grade,dorm_num,room_num,score_time,score_type,score_remarks) values " +
            "(#{health.scoreNum},#{health.grade},#{health.dormNum},#{health.roomNum},#{health.scoreTime},#{health.scoreType},#{health.scoreRemarks})")
    public void insert(@Param("health") Health health);

    @Delete("delete from health_score where id=#{id}")
    public void deleteById(Integer id);

    @Update("update health_score set " +
            "score_num=#{health.scoreNum}," +
            "grade=#{health.grade}," +
            "dorm_num=#{health.dormNum}," +
            "room_num=#{health.roomNum}," +
            "score_time=#{health.scoreTime}," +
            "score_type=#{health.scoreType}," +
            "score_remarks=#{health.scoreRemarks} " +
            "where id=#{health.id}")
    public void update(@Param("health") Health health);

    @Select("select * from health_score where room_num=#{roomNum}")
    public List<Health>getByRoomNum(String roomNum);

}
