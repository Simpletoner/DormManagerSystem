package com.sdut.dorm.service;

import com.sdut.dorm.bean.Late;
import com.sdut.dorm.dao.LateDao;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LateService {
    @Autowired(required = false)
    LateDao lateDao;
    public Result getAll(){
        Result result = new Result();
        List<Late>list = lateDao.getAll();
        result.setMessage("查询成功");
        result.setSuccess(true);
        result.setData(list);
        return result;
    }
    public Result getByStuNum(String stuNum){
        Result result = new Result();
        List<Late>list = lateDao.getByStuNum(stuNum);
        result.setData(list);
        result.setSuccess(true);
        result.setMessage("查询成功");
        return  result;
    }
    public Result insert(Late late){
        Result result = new Result();
        lateDao.insert(late);
        result.setMessage("新建晚归记录成功");
        result.setSuccess(true);
        return result;
    }
    public Result update(Late late){
        Result result = new Result();
        lateDao.update(late);
        result.setSuccess(true);
        result.setMessage("修改成功");
        return  result;
    }

    public Result delete(Late late){
        Result result = new Result();
        lateDao.delete(late);
        result.setMessage("删除成功");
        result.setSuccess(true);
        return result;
    }

}
