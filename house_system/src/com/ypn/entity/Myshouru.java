package com.ypn.entity;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class Myshouru extends BaseDto {
    private Long sid;
    private Long eid;
    private String erealname;
    private Float smoney;
    private  String stm ;
    private  String stime;
    private  String sremark;
    public Myshouru(){}

    public Myshouru(Long sid, Long eid, String erealname, Float smoney, String stm, String stime, String sremark) {
        this.sid = sid;
        this.eid = eid;
        this.erealname = erealname;
        this.smoney = smoney;
        this.stm = stm;
        this.stime = stime;
        this.sremark = sremark;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    public Float getSmoney() {
        return smoney;
    }

    public void setSmoney(Float smoney) {
        this.smoney = smoney;
    }

    public String getStm() {
        return stm;
    }

    public void setStm(String stm) {
        this.stm = stm;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    @Override
    public String toString() {
        return "Myshouru{" +
                "sid=" + sid +
                ", eid=" + eid +
                ", erealname='" + erealname + '\'' +
                ", smoney=" + smoney +
                ", stm='" + stm + '\'' +
                ", stime='" + stime + '\'' +
                ", sremark='" + sremark + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
