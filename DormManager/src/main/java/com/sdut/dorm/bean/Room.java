package com.sdut.dorm.bean;

public class Room {
    Integer id;
    String roomNum;
    Integer roomGender;
    String dormNum;
    Integer bedsNum;
    String checkedInStu;
    Integer checkedInNum;
    String toward;
    String state;
    String roomRemarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getRoomGender() {
        return roomGender;
    }

    public void setRoomGender(Integer roomGender) {
        this.roomGender = roomGender;
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum;
    }

    public Integer getBedsNum() {
        return bedsNum;
    }

    public void setBedsNum(Integer bedsNum) {
        this.bedsNum = bedsNum;
    }

    public String getCheckedInStu() {
        return checkedInStu;
    }

    public void setCheckedInStu(String checkedInStu) {
        this.checkedInStu = checkedInStu;
    }

    public Integer getCheckedInNum() {
        return checkedInNum;
    }

    public void setCheckedInNum(Integer checkedInNum) {
        this.checkedInNum = checkedInNum;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoomRemarks() {
        return roomRemarks;
    }

    public void setRoomRemarks(String roomRemarks) {
        this.roomRemarks = roomRemarks;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNum='" + roomNum + '\'' +
                ", roomGender=" + roomGender +
                ", dormNum='" + dormNum + '\'' +
                ", bedsNum=" + bedsNum +
                ", checkedInStu='" + checkedInStu + '\'' +
                ", checkedInNum=" + checkedInNum +
                ", toward='" + toward + '\'' +
                ", state='" + state + '\'' +
                ", roomRemarks='" + roomRemarks + '\'' +
                '}';
    }
}
