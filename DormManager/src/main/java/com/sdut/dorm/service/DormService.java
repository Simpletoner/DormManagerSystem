package com.sdut.dorm.service;

import com.sdut.dorm.bean.Dorm;
import com.sdut.dorm.bean.Room;
import com.sdut.dorm.dao.DormDao;
import com.sdut.dorm.dao.RoomDao;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormService {
    @Autowired(required = false)
    DormDao dormDao;

    @Autowired(required = false)
    RoomDao roomDao;
    public Result getAll(){
        Result result = new Result();
        try {
            List<Dorm>list = dormDao.getAll();
            result.setSuccess(true);
            result.setMessage("查询成功");
            result.setData(list);
            return result;
        }catch (Exception e){
            result.setMessage("查询失败");
            result.setSuccess(false);
            return result;
        }
    }

    public Result insert(Dorm dorm){
        Result result = new Result();
        for (int i=1;i<=dorm.getDormFloor();i++){
            for (int j=1;j<=dorm.getRoomCount()/dorm.getDormFloor();j++){
                Room room = new Room();
                room.setBedsNum(dorm.getBedsNum());
                room.setRoomGender(Integer.valueOf(dorm.getDormGender()));
                room.setDormNum(dorm.getDormNum());
                room.setToward(Integer.valueOf(i)%2==0?"南":"北");
                Integer num= Integer.valueOf(dorm.getDormNum())*1000+i*100+j;
                room.setRoomNum(num.toString());
                roomDao.insert(room);
            }
        }
        dormDao.insert(dorm);
        result.setSuccess(true);
        result.setMessage("新建楼栋信息成功");
        return result;
    }
}
