package com.sdut.dorm.bean;

import java.util.Date;

public class Health {
    Integer id;
    Integer scoreNum;
    Integer grade;
    String dormNum;
    String roomNum;
    Date scoreTime;
    String scoreType;
    String scoreRemarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Integer scoreNum) {
        this.scoreNum = scoreNum;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Date getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(Date scoreTime) {
        this.scoreTime = scoreTime;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getScoreRemarks() {
        return scoreRemarks;
    }

    public void setScoreRemarks(String scoreRemarks) {
        this.scoreRemarks = scoreRemarks;
    }

    @Override
    public String toString() {
        return "Health{" +
                "id=" + id +
                ", scoreNum=" + scoreNum +
                ", grade=" + grade +
                ", dormNum='" + dormNum + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", scoreTime=" + scoreTime +
                ", scoreType='" + scoreType + '\'' +
                ", scoreRemarks='" + scoreRemarks + '\'' +
                '}';
    }
}
