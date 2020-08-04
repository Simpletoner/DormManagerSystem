package com.sdut.dorm.controller;

import com.sdut.dorm.bean.Notice;
import com.sdut.dorm.service.NoticeService;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notice")
@CrossOrigin
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @PostMapping("/getAll")
    public Result getAllNotice(){
        List<Notice>list = noticeService.getAllNotice();
        Result result = new Result();
        result.setMessage("共查询出"+list.size()+"条通知公告信息");
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    @PostMapping("/getNotice")
    public Result getNotice(@RequestBody Notice notice){

        Integer id = notice.getId();
        Notice no = noticeService.getNoticeById(id);
        Result result = new Result();
        result.setData(no);
        result.setMessage("查询成功");
        return  result;
    }

    @ResponseBody
    @PostMapping("/insertNotice")
    public Result insertNotice(@RequestBody Notice notice){
        System.out.println(notice);
        Result result = new Result();
        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        notice.setNoticeCreateTime(date);
        noticeService.insertNotice(notice);
        result.setMessage("新建通知成功！");
        return result;
    }
    @ResponseBody
    @PostMapping("/updateNotice")
    public Result updateNotice(@RequestBody Notice notice){
        Result result = new Result();
        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        notice.setNoticeCreateTime(date);
        noticeService.updateNotice(notice);
        result.setMessage("更新通知成功！");
        return result;
    }

    @ResponseBody
    @PostMapping("/delete")
    public Result deleteNotice(@RequestBody Notice notice){
        Result result = new Result();
        result.setMessage("成功删除一条通知公告");
        result.setSuccess(true);
        noticeService.deleteNotice(notice);
        return result;
    }
}
