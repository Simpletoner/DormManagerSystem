package com.sdut.dorm.dao;

import com.sdut.dorm.bean.Repair;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RepairDao {
    @Select("select *from repair")
    public List<Repair> selectAll();
    @Select("select * from repair where room_num=#{roomNum}")
    Repair selectByNum(Integer roomNum);

    @Insert("insert into repair (stu_num,dorm_num,room_num,apply_time,repair_time,type,repair_staff,state) values (#{repair.stuNum},#{repair.dormNum},#{repair.roomNum},#{repair.applyTime},#{repair.repairTime},#{repair.type},#{repair.repairStaff},#{repair.state})")
    public void insert(@Param("repair") Repair repair);

    @Delete("delete from repair where id=#{id}")
    public void delete(Integer id);

    @Update("update repair set " +
            "stu_num=#{repair.stuNum}," +
            "dorm_num=#{repair.dormNum}," +
            "room_num=#{repair.roomNum}," +
            "apply_time=#{repair.applyTime}," +
            "repair_time=#{repair.repairTime}," +
            "type=#{repair.type}," +
            "repair_staff=#{repair.repairStaff}," +
            "state=#{repair.state} " +
            "where id=#{repair.id}")
    public void update(@Param("repair")Repair repair);

    @Select("select * from repair where room_num=#{roomNum}")
    public List<Repair> getByRoomNum(String roomNum);
}
