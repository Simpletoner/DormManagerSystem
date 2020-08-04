package com.sdut.dorm.service;

import com.sdut.dorm.bean.Repair;
import com.sdut.dorm.bean.Room;
import com.sdut.dorm.dao.RepairDao;
import com.sdut.dorm.dao.StudentDao;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    @Autowired(required = false)
    private RepairDao repairDao;
    public Result selectAll(){
        Result result = new Result();
        List<Repair> arr =repairDao.selectAll();
        result.setMessage("查询共有"+arr.size()+"条需要维修的宿舍房间信息");
        result.setSuccess(true);
        result.setData(arr);
        return result;
    }

    public Result selectByNum(Integer roomNum) {
        Result result =new Result();
        Repair repair=repairDao.selectByNum(roomNum);
        result.setData(repair);
        return result;
    }

    public Result insert(Repair repair){
        Result result = new Result();
        try {
            repairDao.insert(repair);
            result.setMessage("新增报修信息成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("新增保修信息失败");
            System.out.println(e);
            return result;
        }
    }
    public Result update(Repair repair){
        Result result = new Result();
        try {
            repairDao.update(repair);
            result.setMessage("更新报修信息成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("更新保修信息失败");
            System.out.println(e);
            return result;
        }
    }

    public Result getByRoomNum(String roomNum){
        Result result = new Result();
        try {
            List<Repair> list=repairDao.getByRoomNum(roomNum);
            result.setSuccess(true);
            result.setData(list);
            result.setMessage("共查询出"+list.size()+"条信息");
            return result;
        }catch (Exception e){
            result.setMessage("查询失败");
            result.setSuccess(false);
            System.out.println(e);
            return result;
        }
    }
    public Result delete(Repair repair){
        Result result = new Result();
        repairDao.delete(repair.getId());
        result.setSuccess(true);
        result.setMessage("删除成功");
        return result;
    }
}
