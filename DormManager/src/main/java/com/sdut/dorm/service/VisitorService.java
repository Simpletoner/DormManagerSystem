package com.sdut.dorm.service;

import com.sdut.dorm.bean.Visitor;
import com.sdut.dorm.dao.VisitorDao;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;

@Service
public class VisitorService {
    @Autowired(required = false)
    VisitorDao visitorDao;
    public Result getAll(){
        Result result = new Result();
        List<Visitor>list = visitorDao.getAll();
        result.setSuccess(true);
        result.setMessage("查询成功");
        result.setData(list);
        return result;
    }

    public Result getByStuNum(String stuNum){
        Result result = new Result();
        List<Visitor>list = visitorDao.getByStuNum(stuNum);
        result.setData(list);
        result.setMessage("查询成功");
        result.setSuccess(true);
        return result;
    }

    public Result insert(Visitor visitor){
        Result result = new Result();
        visitorDao.insert(visitor);
        result.setSuccess(true);
        result.setMessage("新建访客记录成功");
        result.setSuccess(true);
        return result;
    }
    public Result delete(Visitor visitor){
        Result result = new Result();
        visitorDao.delete(visitor);
        result.setSuccess(true);
        result.setMessage("删除成功");
        return result;
    }
    public Result update(Visitor visitor){
        Result result = new Result();
        visitorDao.update(visitor);
        result.setMessage("修改成功");
        result.setSuccess(true);
        return result;
    }
}
