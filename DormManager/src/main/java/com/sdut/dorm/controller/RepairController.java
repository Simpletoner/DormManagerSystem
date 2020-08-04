package com.sdut.dorm.controller;

import com.sdut.dorm.bean.Repair;
import com.sdut.dorm.service.RepairService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rep")
@CrossOrigin
public class RepairController {
    @Autowired
    RepairService repairService;
    @PostMapping("/getAll")
    public Result selectAll(){
        return repairService.selectAll();
    }
    @PostMapping("/selectByNum")
    public Result selectByNum(Integer roomNum){
        return repairService.selectByNum(roomNum);
    }
    @PostMapping("/insert")
    public Result insert(@RequestBody Repair repair){
        return repairService.insert(repair);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Repair repair){
        return repairService.update(repair);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Repair repair){
        return repairService.delete(repair);
    }
}
