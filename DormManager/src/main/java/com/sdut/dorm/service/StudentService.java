package com.sdut.dorm.service;

import com.sdut.dorm.bean.Student;
import com.sdut.dorm.dao.StudentDao;
import com.sdut.dorm.util.Result;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired(required = false)
    private StudentDao studentDao;

    public Result notInDorm(){
        ArrayList<Student> arr = new ArrayList<>();
        arr=studentDao.notInDorm();
        Result result = new Result();
        if(arr.size()!=0){
            result.setMessage("查询成功，共有"+arr.size()+"条学生信息");
            result.setSuccess(true);
            result.setData(arr);
            System.out.println(arr);
            return result;
        }
        result.setMessage("已全部入住");
        result.setSuccess(true);
        result.setData(arr);
        return result;
    }
    public Student getStuById(String stuNum){
        return studentDao.getStuById(stuNum);
    }

    public Result getAll(){
        Result result = new Result();
        try {
            List<Student> list = studentDao.getAll();
            result.setSuccess(true);
            result.setData(list);
            result.setMessage("共查询出"+list.size()+"条学生信息");
            return result;
        }catch (Exception e){
            result.setMessage("获取失败");
            result.setSuccess(false);
            return result;
        }
    }
    public Result getByClass(String stuClass){
        Result result = new Result();
        try {
            List<Student> list = studentDao.getByClass(stuClass);
            result.setMessage("共查询出"+list.size()+"条学生信息");
            result.setSuccess(true);
            result.setData(list);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
            return result;
        }
    }
    public Result insert(Student student){
        Result result = new Result();
        try {
            studentDao.insert(student);
            result.setMessage("新建学生信息成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("新建学生信息失败");
            return result;
        }
    }
    public Result update(Student student){
        Result result = new Result();
        try {
            studentDao.update(student);
            result.setMessage("更新学生信息成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("更新学生信息失败");
            return result;
        }
    }
    public Result delete(Student student){
        Result result = new Result();
        try {
            studentDao.delete(student);
            result.setMessage("删除学生信息成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("删除学生信息失败");
            return result;
        }
    }
}
