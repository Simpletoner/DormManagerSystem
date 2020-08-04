package com.sdut.dorm.controller;

import com.sdut.dorm.bean.Room;
import com.sdut.dorm.service.RoomService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class RoomController {
    @Autowired(required = false)
    RoomService roomService;
    @PostMapping("/getAll")
    public Result getAll(){
        return roomService.getAll();
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Room room){
        return roomService.insert(room);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Room room){
        return roomService.delete(room);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Room room){
        return roomService.update(room);
    }

    @PostMapping("/getByDormNum")
    public Result getByDormNum(String dormNum){
        return roomService.getByDormNum(dormNum);
    }
}

