package com.sdut.dorm.dao;

import com.sdut.dorm.bean.SysAdmin;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysAdminDao {
    @Select("select * from sys_admin where sys_admin_num=#{username}")
    SysAdmin login(@Param("username")String username);

    @Insert("insert into sys_admin (" +
            "sys_admin_num," +
            "sys_admin_name," +
            "sys_admin_pwd," +
            "sys_admin_gender," +
            "sys_admin_tel," +
            "sys_admin_email" +
            ") values(" +
            "#{sysAdmin.sysAdminNum}," +
            "#{sysAdmin.sysAdminName}," +
            "#{sysAdmin.sysAdminPwd}," +
            "#{sysAdmin.sysAdminGender}," +
            "#{sysAdmin.sysAdminTel}," +
            "#{sysAdmin.sysAdminEmail})")
    Boolean regist(@Param("sysAdmin")SysAdmin sysAdmin);
}
