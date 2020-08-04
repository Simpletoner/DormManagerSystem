package com.sdut.dorm.controller;

import com.sdut.dorm.bean.Visitor;
import com.sdut.dorm.service.VisitorService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitor")
@CrossOrigin
public class VisitorController {
    @Autowired
    VisitorService visitorService;
    @PostMapping("/getAll")
    public Result getAll(){
        return visitorService.getAll();
    }
    @PostMapping("/getByStuNum")
    public Result getByStuNum(String stuNum){
        return visitorService.getByStuNum(stuNum);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Visitor visitor){
        return visitorService.insert(visitor);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Visitor visitor){
        return visitorService.delete(visitor);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Visitor visitor){
        return visitorService.update(visitor);
    }
}
