package com.sdut.dorm.controller;

import com.sdut.dorm.bean.Dorm;
import com.sdut.dorm.service.DormService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dorm")
@CrossOrigin
public class DormController {
    @Autowired
    DormService dormService;

    @PostMapping("/getAll")
    public Result getAll(){
        return dormService.getAll();
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Dorm dorm){
        return dormService.insert(dorm);
    }

}
