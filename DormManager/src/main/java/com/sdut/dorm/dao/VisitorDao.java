package com.sdut.dorm.dao;

import com.sdut.dorm.bean.Visitor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VisitorDao {
    @Select("select * from visitor")
    List<Visitor> getAll();

    @Select("select * from visitor where stu_num=#{stuNum}")
    List<Visitor> getByStuNum(String stuNum);

    @Insert("insert into visitor (visitor_name,relationship,reason,stu_num,dorm_num,room_num,visit_date,leave_date) values " +
            "(#{visitor.visitorName},#{visitor.relationship},#{visitor.reason},#{visitor.stuNum},#{visitor.dormNum},#{visitor.roomNum},#{visitor.visitDate},#{visitor.leaveDate})")
    void insert(@Param("visitor") Visitor visitor);

    @Update("update visitor set " +
            "visitor_name=#{visitor.visitorName}," +
            "relationship=#{visitor.relationship}," +
            "reason=#{visitor.reason}," +
            "stu_num=#{visitor.stuNum}," +
            "dorm_num=#{visitor.dormNum}," +
            "room_num=#{visitor.roomNum}," +
            "visit_date=#{visitor.visitDate}," +
            "leave_date=#{visitor.leaveDate} " +
            "where id=#{visitor.id}")
    void update(@Param("visitor") Visitor visitor);

    @Delete("delete from visitor where id=#{visitor.id}")
    void delete(@Param("visitor")Visitor visitor);
}
