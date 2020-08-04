package com.sdut.dorm.bean;


public class Late {
    Integer id;
    String stuNum;
    String dormNum;
    String roomNum;
    String lateTime;
    String reason;
    String dormAdminNum;

    @Override
    public String toString() {
        return "Late{" +
                "id=" + id +
                ", stuNum='" + stuNum + '\'' +
                ", dormNum='" + dormNum + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", lateTime='" + lateTime + '\'' +
                ", reason='" + reason + '\'' +
                ", dormAdminNum='" + dormAdminNum + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
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

    public String getLateTime() {
        return lateTime;
    }

    public void setLateTime(String lateTime) {
        this.lateTime = lateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDormAdminNum() {
        return dormAdminNum;
    }

    public void setDormAdminNum(String dormAdminNum) {
        this.dormAdminNum = dormAdminNum;
    }
}
