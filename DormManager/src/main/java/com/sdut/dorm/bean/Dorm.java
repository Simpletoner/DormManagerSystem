package com.sdut.dorm.bean;

public class Dorm {
    Integer id;
    String dormName;
    String dormNum;
    Integer bedsNum;
    String dormType;
    Integer roomCount;
    String dormGender;
    Integer dormFloor;
    String dormGroup;
    String state;

    @Override
    public String toString() {
        return "Dorm{" +
                "id=" + id +
                ", dormName='" + dormName + '\'' +
                ", dormNum='" + dormNum + '\'' +
                ", bedsNum=" + bedsNum +
                ", dormType='" + dormType + '\'' +
                ", roomCount=" + roomCount +
                ", dormGender='" + dormGender + '\'' +
                ", dormFloor=" + dormFloor +
                ", dormGroup='" + dormGroup + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public Integer getBedsNum() {
        return bedsNum;
    }

    public void setBedsNum(Integer bedsNum) {
        this.bedsNum = bedsNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum;
    }

    public String getDormType() {
        return dormType;
    }

    public void setDormType(String dormType) {
        this.dormType = dormType;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public String getDormGender() {
        return dormGender;
    }

    public void setDormGender(String dormGender) {
        this.dormGender = dormGender;
    }

    public Integer getDormFloor() {
        return dormFloor;
    }

    public void setDormFloor(Integer dormFloor) {
        this.dormFloor = dormFloor;
    }

    public String getDormGroup() {
        return dormGroup;
    }

    public void setDormGroup(String dormGroup) {
        this.dormGroup = dormGroup;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
