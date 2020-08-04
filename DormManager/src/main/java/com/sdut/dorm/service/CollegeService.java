package com.sdut.dorm.service;

import com.sdut.dorm.bean.College;
import com.sdut.dorm.dao.CollegeDao;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired(required = false)
    private CollegeDao collegeDao;

    public Result getAll(){
        Result result = new Result();
        try {
            List<College> list =collegeDao.getAll();
            result.setData(list);
            result.setMessage("共查询出"+list.size()+"条数据");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("获取学院信息失败");
            return result;
        }
    }

    public Result insert(College college){
        Result result = new Result();
        try {
            collegeDao.insert(college);
            result.setMessage("新建学院信息成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("新建学员信息失败");
            return result;
        }
    }

    public Result update(College college){
        Result result = new Result();
        try {
            collegeDao.update(college);
            result.setMessage("更新学院信息成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("更新学员信息失败");
            return result;
        }
    }

    public Result delete(College college){
        Result result = new Result();
        try {
            collegeDao.delete(college);
            result.setMessage("删除学院信息成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("删除学员信息失败");
            return result;
        }
    }
}
