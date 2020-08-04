package com.sdut.dorm.dao;

import com.sdut.dorm.bean.Student;
import com.sdut.dorm.bean.SysAdmin;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface StudentDao {
    @Select("select * from student where is_in_dorm=0")
    ArrayList<Student> notInDorm();

    @Update("update student set " +
            "stu_name=#{student.stuName}," +
            "stu_num=#{student.stuNum}," +
            "stu_gender=#{student.stuGender}," +
            "stu_college=#{student.stuCollege}," +
            "stu_class=#{student.stuClass}," +
            "is_in_dorm=#{student.isInDorm}," +
            "stu_dorm=#{student.stuDorm}," +
            "stu_room=#{student.stuRoom} " +
            "where stu_num=#{student.stuNum}")
    void update(@Param("student") Student student);

    @Select("select * from student where is_in_dorm=1")
    ArrayList<Student> getInDorm();

    @Update("update student set is_in_dorm=0,stu_dorm=null,stu_room=null where stu_num=#{student.stuNum}")
    void checkOutStu(@Param("student") Student student);

    @Select("select * from student where stu_num=#{stuNum}")
    Student getStuById(String stuNum);

    @Select("select * from student")
    List<Student> getAll();

    @Select("select * from student where stu_class like '%${stuClass}%'")
    List<Student> getByClass(@Param("stuClass") String stuClass);

    @Insert("insert into student (stu_name,stu_num,stu_gender,stu_college,stu_class) values (#{student.stuName},#{student.stuNum},#{student.stuGender},#{student.stuCollege},#{student.stuClass})")
    void insert(@Param("student") Student student);

    @Delete("delete from student where id=#{student.id}")
    void delete(@Param("student") Student student);
}
