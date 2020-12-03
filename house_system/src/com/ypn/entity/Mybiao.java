package com.ypn.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class Mybiao extends BaseDto {
    private Long bid;//编号
    private Long hid;//房子编号
    private String haddress;//房子地址
    private String hfh;//房号
    private Float dkd;//点刻度
    private Float skd;//水刻度
    private Float mkd;//煤刻度
    private String mtime;//操表时间
    private Long eid;//经办人编号
    private String ename;//经办人姓名

    public Mybiao() {
    }


    public Mybiao(Long bid, Long hid, String haddress, String hfh, Float dkd, Float skd, Float mkd, String mtime, Long eid, String ename) {
        this.bid = bid;
        this.hid = hid;
        this.haddress = haddress;
        this.hfh = hfh;
        this.dkd = dkd;
        this.skd = skd;
        this.mkd = mkd;
        this.mtime = mtime;
        this.eid = eid;
        this.ename = ename;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHfh() {
        return hfh;
    }

    public void setHfh(String hfh) {
        this.hfh = hfh;
    }

    public Float getDkd() {
        return dkd;
    }

    public void setDkd(Float dkd) {
        this.dkd = dkd;
    }

    public Float getSkd() {
        return skd;
    }

    public void setSkd(Float skd) {
        this.skd = skd;
    }

    public Float getMkd() {
        return mkd;
    }

    public void setMkd(Float mkd) {
        this.mkd = mkd;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Mybiao{" +
                "bid=" + bid +
                ", hid=" + hid +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", dkd=" + dkd +
                ", skd=" + skd +
                ", mkd=" + mkd +
                ", mtime='" + mtime + '\'' +
                ", eid=" + eid +
                ", ename='" + ename + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
