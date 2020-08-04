package com.sdut.dorm.service;

import com.sdut.dorm.bean.Notice;
import com.sdut.dorm.dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired(required = false)
    private NoticeDao noticeDao;

    public List<Notice> getAllNotice(){
        return noticeDao.selectAll();
    }

    public Notice getNoticeById(Integer id){
        return noticeDao.selectById(id);
    }

    public void insertNotice(Notice notice){
        noticeDao.insertNotice(notice);
    }

    public void updateNotice(Notice notice){
        noticeDao.updateById(notice);
    }

    public void deleteNotice(Notice notice){
        noticeDao.delete(notice);
    }
}
