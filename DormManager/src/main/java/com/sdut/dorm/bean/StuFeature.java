package com.sdut.dorm.bean;

public class StuFeature {
    String stuNum;
    Integer getUpTime;
    Integer SleepTime;
    Integer afternoon;
    Integer nature;
    Integer sport;
    Integer game;
    Integer literature;
    Integer music;
    Integer sanitation;
    Integer cost;
    Integer source;

    @Override
    public String toString() {
        return "StuFeature{" +
                "stuNum='" + stuNum + '\'' +
                ", getUpTime=" + getUpTime +
                ", SleepTime=" + SleepTime +
                ", afternoon=" + afternoon +
                ", nature=" + nature +
                ", sport=" + sport +
                ", game=" + game +
                ", literature=" + literature +
                ", music=" + music +
                ", sanitation=" + sanitation +
                ", cost=" + cost +
                ", source=" + source +
                ", residence=" + residence +
                '}';
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public Integer getGetUpTime() {
        return getUpTime;
    }

    public void setGetUpTime(Integer getUpTime) {
        this.getUpTime = getUpTime;
    }

    public Integer getSleepTime() {
        return SleepTime;
    }

    public void setSleepTime(Integer sleepTime) {
        SleepTime = sleepTime;
    }

    public Integer getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Integer afternoon) {
        this.afternoon = afternoon;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public Integer getSport() {
        return sport;
    }

    public void setSport(Integer sport) {
        this.sport = sport;
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public Integer getLiterature() {
        return literature;
    }

    public void setLiterature(Integer literature) {
        this.literature = literature;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
    }

    public Integer getSanitation() {
        return sanitation;
    }

    public void setSanitation(Integer sanitation) {
        this.sanitation = sanitation;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getResidence() {
        return residence;
    }

    public void setResidence(Integer residence) {
        this.residence = residence;
    }

    Integer residence;
}
