package com.sdut.dorm.dao;

import com.sdut.dorm.bean.College;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.Collections;
import java.util.List;

@Mapper
public interface CollegeDao {
    @Select("select * from college")
    List<College> getAll();

    @Insert("insert into college (college_name) values (#{college.collegeName})")
    void insert(@Param("college")College college);

    @Delete("delete from college where id=#{college.id}")
    void delete(@Param("college") College college);

    @Update("update college set college_name=#{college.collegeName}")
    void update(@Param("college") College college);
}
