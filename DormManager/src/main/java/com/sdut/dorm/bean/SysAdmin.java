package com.sdut.dorm.bean;

public class SysAdmin {
    private Integer id;
    private String sysAdminNum;
    private String sysAdminName;
    private String sysAdminPwd;
    private String sysAdminGender;
    private String sysAdminTel;
    private String sysAdminEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysAdminNum() {
        return sysAdminNum;
    }

    public void setSysAdminNum(String sysAdminNum) {
        this.sysAdminNum = sysAdminNum;
    }

    public String getSysAdminName() {
        return sysAdminName;
    }

    public void setSysAdminName(String sysAdminName) {
        this.sysAdminName = sysAdminName;
    }

    public String getSysAdminPwd() {
        return sysAdminPwd;
    }

    public void setSysAdminPwd(String sysAdminPwd) {
        this.sysAdminPwd = sysAdminPwd;
    }

    public String getSysAdminGender() {
        return sysAdminGender;
    }

    public void setSysAdminGender(String sysAdminGender) {
        this.sysAdminGender = sysAdminGender;
    }

    public String getSysAdminTel() {
        return sysAdminTel;
    }

    public void setSysAdminTel(String sysAdminTel) {
        this.sysAdminTel = sysAdminTel;
    }

    public String getSysAdminEmail() {
        return sysAdminEmail;
    }

    public void setSysAdminEmail(String sysAdminEmail) {
        this.sysAdminEmail = sysAdminEmail;
    }

    @Override
    public String toString() {
        return "SysAdmin{" +
                "id=" + id +
                ", sysAdminNum='" + sysAdminNum + '\'' +
                ", sysAdminName='" + sysAdminName + '\'' +
                ", sysAdminPwd='" + sysAdminPwd + '\'' +
                ", sysAdminGender='" + sysAdminGender + '\'' +
                ", sysAdminTel='" + sysAdminTel + '\'' +
                ", sysAdminEmail='" + sysAdminEmail + '\'' +
                '}';
    }
}
