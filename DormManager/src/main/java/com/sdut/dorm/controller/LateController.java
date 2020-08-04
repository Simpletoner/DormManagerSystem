package com.sdut.dorm.controller;

import com.sdut.dorm.bean.Late;
import com.sdut.dorm.service.LateService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/late")
@CrossOrigin
public class LateController {
    @Autowired
    LateService lateService;
    @PostMapping("/getAll")
    public Result getAll(){
        return lateService.getAll();
    }

    @PostMapping("/getByStuNum")
    public Result getByStuNum(String stuNum){
        return lateService.getByStuNum(stuNum);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Late late){
        return lateService.insert(late);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Late late){
        return lateService.delete(late);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Late late){
        return lateService.update(late);
    }
}
