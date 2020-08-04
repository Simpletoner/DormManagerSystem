package com.sdut.dorm.bean;

public class College {
    private Integer id;
    private String collegeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollege() {
        return collegeName;
    }

    public void setCollege(String college) {
        this.collegeName = college;
    }

    @Override
    public String toString() {
        return "college{" +
                "id=" + id +
                ", college='" + collegeName + '\'' +
                '}';
    }
}
