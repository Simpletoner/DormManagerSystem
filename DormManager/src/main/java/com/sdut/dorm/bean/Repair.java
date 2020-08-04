package com.sdut.dorm.bean;

import java.util.Date;

public class Repair {
    private Integer id;
    private String stuNum;
    private String roomNum;
    private String dormNum;
    private Date applyTime;
    private Date repairTime;
    private String type;
    private String repairStaff;
    private String state;
    private String dormAdminNum;

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", stuNum='" + stuNum + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", applyTime=" + applyTime +
                ", repairTime=" + repairTime +
                ", type='" + type + '\'' +
                ", repairStaff='" + repairStaff + '\'' +
                ", state='" + state + '\'' +
                ", dormAdminNum='" + dormAdminNum + '\'' +
                '}';
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum;
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

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRepairStaff() {
        return repairStaff;
    }

    public void setRepairStaff(String repairStaff) {
        this.repairStaff = repairStaff;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDormAdminNum() {
        return dormAdminNum;
    }

    public void setDormAdminNum(String dormAdminNum) {
        this.dormAdminNum = dormAdminNum;
    }
}
