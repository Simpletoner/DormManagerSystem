package com.sdut.dorm.dao;

import com.sdut.dorm.bean.Room;
import com.sdut.dorm.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomDao {
//    查找没有住满的房间
    @Select("select * from room where state=1 and checked_in_num != beds_num")
    List<Room> getNotFullRoom();
//    更新房间信息
    @Update("update room set " +
            "checked_in_num=#{room.checkedInNum}," +
            "room_gender=#{room.roomGender}," +
            "dorm_num=#{room.dormNum}," +
            "beds_num=#{room.bedsNum}," +
            "toward=#{room.toward}," +
            "state=#{room.state} " +
            "where room_num=#{room.roomNum}")
    void updateRoom(@Param("room") Room room);
//    根据房间号查询房间信息
    @Select("select * from room where room_num=#{roomNum}")
    Room getRoomById(String roomNum);
//    查询所有房间信息
    @Select("select * from room")
    List<Room> selectAll();
//    根据id删除房间
    @Delete("delete from room where room_num=#{roomNum}")
     void deleteById(String roomNum);

    @Insert("insert into room (room_gender,room_num,dorm_num,beds_num,toward) values " +
            "(#{room.roomGender},#{room.roomNum},#{room.dormNum},#{room.bedsNum},#{room.toward})")
    void insert(@Param("room")Room room);

    @Select("select * from room where dorm_num=#{dormNum}")
    public List<Room> getByDormNum(String dormNum);
}
