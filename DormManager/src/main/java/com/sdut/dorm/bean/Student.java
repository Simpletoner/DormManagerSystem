package com.sdut.dorm.bean;

public class Student {
    Integer id;
    String stuName;
    String stuNum;
    Integer stuGender;
    Integer isInDorm;
    String stuDorm;
    String stuRoom;

    public String getStuDorm() {
        return stuDorm;
    }

    public void setStuDorm(String stuDorm) {
        this.stuDorm = stuDorm;
    }

    public String getStuRoom() {
        return stuRoom;
    }

    public void setStuRoom(String stuRoom) {
        this.stuRoom = stuRoom;
    }

    String stuCollege;
    String stuPwd;
    String stuTel;
    String stuEmail;
    String stuClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Integer getStuGender() {
        return stuGender;
    }

    public void setStuGender(Integer stuGender) {
        this.stuGender = stuGender;
    }

    public Integer getIsInDorm() {
        return isInDorm;
    }

    public void setIsInDorm(Integer isInDorm) {
        this.isInDorm = isInDorm;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", stuGender=" + stuGender +
                ", isInDorm=" + isInDorm +
                ", stuDorm='" + stuDorm + '\'' +
                ", stuRoom='" + stuRoom + '\'' +
                ", stuCollege='" + stuCollege + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", stuClass='" + stuClass + '\'' +
                '}';
    }
}
