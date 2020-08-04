package com.sdut.dorm.dao;

import com.sdut.dorm.bean.Late;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LateDao {
    @Select("select * from late")
    List<Late> getAll();

    @Select("select * from late where stu_num=#{stuNum}")
    List<Late> getByStuNum(String stuNum);

    @Insert("insert into late (stu_num,dorm_num,room_num,late_time,reason,dorm_admin_num) values " +
            "(#{late.stuNum},#{late.dormNum},#{late.roomNum},#{late.lateTime},#{late.reason},#{late.dormAdminNum})")
    void insert(@Param("late")Late late);

    @Update("update late set " +
            "stu_num=#{late.stuNum}," +
            "dorm_num=#{late.dormNum}," +
            "room_num=#{late.roomNum}," +
            "late_time=#{late.lateTime}," +
            "reason=#{late.reason}," +
            "dorm_admin_num=#{late.dormAdminNum} " +
            "where id=#{late.id}")
    void update(@Param("late")Late late);

    @Delete("delete from late where id=#{late.id}")
    void delete(@Param("late") Late late);
}
