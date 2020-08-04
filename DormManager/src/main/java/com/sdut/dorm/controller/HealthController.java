package com.sdut.dorm.controller;

import com.sdut.dorm.bean.Health;
import com.sdut.dorm.service.HealthService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
@CrossOrigin
public class HealthController {
    @Autowired
    HealthService healthService;

    @PostMapping("/getAll")
    public Result getAll(){
        return healthService.getAll();
    }

    @PostMapping("/getById")
    public Result getById(Integer id){
        return healthService.getHealthById(id);
    }

    @PostMapping("/getByRoomNum")
    public Result getByRoomNum(String roomNum){
        return healthService.getByRoomNum(roomNum);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Health health){
        return healthService.insertHealth(health);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Health health){
        return healthService.delete(health);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Health health){
        return healthService.update(health);
    }
}
