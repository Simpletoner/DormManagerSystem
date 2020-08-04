package com.sdut.dorm.service;

import com.sdut.dorm.bean.Health;
import com.sdut.dorm.dao.HealthDao;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class HealthService {
    @Autowired(required = false)
    private HealthDao healthDao;
    public Result getAll(){
        Result result = new Result();
        List<Health> list = healthDao.getAll();
        result.setData(list);
        result.setMessage("共查询出"+list.size()+"条信息");
        result.setSuccess(true);
        return result;
    }

    public Result getHealthById(Integer id){
        Result result = new Result();
        Health health = healthDao.getHealthById(id);
        if(health == null){
            result.setMessage("没有该条记录信息");
            result.setSuccess(false);
            return result;
        }
        result.setData(health);
        result.setSuccess(true);
        result.setMessage("查询成功");
        return result;
    }

    public Result insertHealth(Health health){
        Result result = new Result();
        try {
            Date date = new Date();
            health.setScoreTime(date);
            healthDao.insert(health);
            result.setMessage("新增卫生评分成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("新增卫生评分失败");
            return result;
        }
    }

    public Result getByRoomNum(String roomNum){
        Result result = new Result();
        List<Health>list = healthDao.getByRoomNum(roomNum);
        if(list.size() == 0){
            result.setSuccess(false);
            result.setMessage("并没有该宿舍的卫生记录");
            result.setData(null);
            return result;
        }else{
            result.setData(list);
            result.setMessage("共查询出"+list.size()+"条信息");
            result.setSuccess(true);
            return result;
        }
    }

    public Result update(Health health){
        Result result = new Result();
        try {
            Date date = new Date();
            health.setScoreTime(date);
            healthDao.update(health);
            result.setMessage("更新成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("更新失败"+e);
            return result;
        }
    }
    public Result delete(Health health){
        Result result = new Result();
        try {
            healthDao.deleteById(health.getId());
            result.setMessage("删除成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("删除失败");
            return result;
        }
    }

}
