package com.sdut.dorm.bean;

import java.util.Date;

public class Notice {
    Integer id;
    String noticeTitle;
    String noticeContent;
    String noticePublisher;
    Date noticeCreateTime;
    String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticePublisher() {
        return noticePublisher;
    }

    public void setNoticePublisher(String noticePublisher) {
        this.noticePublisher = noticePublisher;
    }

    public Date getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(Date noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "notice{" +
                "id='" + id + '\'' +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticePublisher='" + noticePublisher + '\'' +
                ", noticeCreateTime=" + noticeCreateTime +
                ", state='" + state + '\'' +
                '}';
    }
}
