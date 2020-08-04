package com.sdut.dorm.service;

import com.sdut.dorm.bean.Room;
import com.sdut.dorm.dao.RoomDao;
import com.sdut.dorm.util.Result;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired(required = false)
    private RoomDao roomDao;
    public Room getRoomById(String roomNum){
        return roomDao.getRoomById(roomNum);
    }
    public Result getAll(){
        Result result = new Result();
        try {
            List<Room> list = roomDao.selectAll();
            result.setMessage("共查询出"+list.size()+"条信息");
            result.setData(list);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("查询失败");
            return  result;
        }
    }
    public Result delete(Room room){
        Result result = new Result();
        try {
            roomDao.deleteById(room.getRoomNum());
            result.setSuccess(true);
            result.setMessage("删除房间信息成功");
            return result;
        }catch (Exception e){
            result.setMessage("删除失败");
            result.setSuccess(false);
            return result;
        }
    }

    public Result update(Room room){
        Result result = new Result();
        try {
            roomDao.updateRoom(room);
            result.setSuccess(true);
            result.setMessage("更新房间信息成功");
            return  result;
        }catch (Exception e){
            result.setMessage("更新房间信息失败");
            result.setSuccess(false);
            return result;
        }
    }

    public Result insert(Room room){
        Result result = new Result();
        try {
            roomDao.insert(room);
            result.setSuccess(true);
            result.setMessage("新增房间成功");
            return result;
        }catch (Exception e){
            result.setMessage("新增房间失败");
            result.setSuccess(false);
            return result;
        }
    }

    public Result getByDormNum(String dormNum){
        Result result = new Result();
        try {
            List<Room>list=roomDao.getByDormNum(dormNum);
            result.setData(list);
            result.setMessage("共查询出"+list.size()+"条数据");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            result.setMessage("查询失败");
            result.setSuccess(false);
            return result;
        }
    }

}
