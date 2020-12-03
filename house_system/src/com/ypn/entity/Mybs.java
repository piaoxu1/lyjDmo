package com.ypn.entity;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class Mybs extends BaseDto {
    private Long bid;
    private Long hid;
    private String haddress;
    private  String hfh;
    private String mtime;
    private String bremark;
    private Long eid;
    private String erealname;
public Mybs(){}

    public Mybs(Long bid, Long hid, String haddress, String hfh, String mtime, String bremark, Long eid, String erealname) {
        this.bid = bid;
        this.hid = hid;
        this.haddress = haddress;
        this.hfh = hfh;
        this.mtime = mtime;
        this.bremark = bremark;
        this.eid = eid;
        this.erealname = erealname;
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

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getBremark() {
        return bremark;
    }

    public void setBremark(String bremark) {
        this.bremark = bremark;
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

    @Override
    public String toString() {
        return "Mybs{" +
                "bid=" + bid +
                ", hid=" + hid +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", mtime='" + mtime + '\'' +
                ", bremark='" + bremark + '\'' +
                ", eid=" + eid +
                ", erealname='" + erealname + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
