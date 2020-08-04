package com.sdut.dorm.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sdut.dorm.bean.Room;
import com.sdut.dorm.bean.Student;
import com.sdut.dorm.bean.SysAdmin;
import com.sdut.dorm.service.RoomService;
import com.sdut.dorm.service.StudentService;
import com.sdut.dorm.service.SysAdminService;
import com.sdut.dorm.util.Result;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys")
@CrossOrigin
public class SysAdminController {

    @Autowired
    private SysAdminService sysAdminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private RoomService roomService;
    @PostMapping("/sysLogin")
    public Result login(SysAdmin sysAdmin, HttpServletRequest request){
        System.out.println(sysAdmin+"controller");
        return sysAdminService.sysLogin(sysAdmin,request);
    }

    @PostMapping("/sysRegist")
    public Boolean regist(SysAdmin sysAdmin,HttpServletRequest request){
        return sysAdminService.sysRegist(sysAdmin,request);
    }

    @RequestMapping(value = "/autoInDorm",method = RequestMethod.POST)
    public Result autoInDorm(@RequestBody List<Student> students){
        System.out.println(students);
        Result result = sysAdminService.autoInDorm(students);
        return result;
    }
    @PostMapping("/getInDorm")
    public Result getInDorm(){
        return sysAdminService.getInDorm();
    }

    @PostMapping("/checkOut")
    public Result checkOut(@RequestBody List<Student> students){
        return sysAdminService.checkOut(students);
    }
    @PostMapping("/selectAll")
    public Result selectAll(){
        return sysAdminService.selectAll();
    }
    @PostMapping("/deleteAny")
    public Result deleteAny(List<Room> list){
        return sysAdminService.deleteAny(list);
    }
    @PostMapping("/getNotFullRoom")
    public Result getNotFullRoom(String stuNum){
        System.out.println(stuNum);
        return sysAdminService.getNotFullRoom(stuNum);
    }

    @PostMapping("/inRoom")
    public Result inRoom(String stuNum,String roomNum){
//        System.out.println(stuNum+roomNum);
        Student student = studentService.getStuById(stuNum);
        Room room = roomService.getRoomById(roomNum);
        return sysAdminService.stuInRoom(student,room);
    }
     @PostMapping("/change")
    public Result change(String stuNum,String roomNum){
        System.out.println(stuNum+roomNum);
        Student student = studentService.getStuById(stuNum);
        Room room = roomService.getRoomById(roomNum);
        return sysAdminService.change(student,room);
//         Result result = new Result();
//         return result;
     }

}
