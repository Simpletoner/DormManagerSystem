package com.sdut.dorm.bean;

import javax.xml.crypto.Data;
import java.util.Date;

public class Visitor {
    Integer id;
    String visitorName;
    String relationship;
    String reason;
    String stuNum;
    String dormNum;
    String roomNum;
    Date visitDate;
    Date leaveDate;

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorName='" + visitorName + '\'' +
                ", relationship='" + relationship + '\'' +
                ", reason='" + reason + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", dormNum='" + dormNum + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", visitDate=" + visitDate +
                ", leaveDate=" + leaveDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }
}
