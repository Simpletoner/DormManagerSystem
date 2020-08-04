package com.sdut.dorm.controller;

import com.sdut.dorm.bean.College;
import com.sdut.dorm.service.CollegeService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college")
@CrossOrigin
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping("/getAll")
    public Result getAll(){
        return collegeService.getAll();
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody College college){
        return collegeService.insert(college);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody College college){
        return collegeService.delete(college);
    }
    @PostMapping("/update")
    public Result update(@RequestBody College college){
        return collegeService.update(college);
    }

}
