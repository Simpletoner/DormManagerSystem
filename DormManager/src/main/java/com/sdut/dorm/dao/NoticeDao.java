package com.sdut.dorm.dao;

import com.sdut.dorm.bean.Notice;
import com.sun.tools.corba.se.idl.constExpr.Not;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeDao {

    @Select("select * from notice_info")
    List<Notice> selectAll();

    @Select("select * from notice_info where id=#{id}")
    Notice selectById(Integer id);

    @Insert("insert into notice_info (notice_title,notice_content,notice_create_time,state) values (#{notice.noticeTitle},#{notice.noticeContent},#{notice.noticeCreateTime},#{notice.state})")
    void insertNotice(@Param("notice") Notice notice);

    @Update("update notice_info set notice_title=#{notice.noticeTitle},notice_content=#{notice.noticeContent},state=#{notice.state}" +
            "where id=#{notice.id}")
    void updateById(@Param("notice") Notice notice);

    @Delete("delete from notice_info where id=#{notice.id}")
    void delete(@Param("notice") Notice notice);
}
