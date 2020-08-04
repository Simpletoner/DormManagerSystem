package com.sdut.dorm.controller;

import com.sdut.dorm.bean.Student;
import com.sdut.dorm.bean.SysAdmin;
import com.sdut.dorm.service.StudentService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/stu")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/notInDorm")
    public Result notInDorm(HttpServletRequest request){
        return studentService.notInDorm();
    }

    @PostMapping("/getAll")
    public Result getAll(){
        return studentService.getAll();
    }

    @PostMapping("/getByClass")
    public Result getByClass(String stuClass){
        return studentService.getByClass(stuClass);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Student student){
        return studentService.insert(student);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Student student){
        return studentService.update(student);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Student student){
        return studentService.delete(student);
    }
}

