package com.ypn.entity;


/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc 日常房屋支出信息实体类
 */
public class Myzhichu extends BaseDto {
    private Long zid;
    private Long eid;
    private String erealname;
    private String ztm;
    private Float zmoney;
    private String ztime;
    private String zremark;

    public Myzhichu() {
    }

    public Myzhichu(Long zid, Long eid, String erealname, String ztm, Float zmoney, String ztime, String zremark) {
        this.zid = zid;
        this.eid = eid;
        this.erealname = erealname;
        this.ztm = ztm;
        this.zmoney = zmoney;
        this.ztime = ztime;
        this.zremark = zremark;
    }

    public Long getZid() {
        return zid;
    }

    public void setZid(Long zid) {
        this.zid = zid;
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

    public String getZtm() {
        return ztm;
    }

    public void setZtm(String ztm) {
        this.ztm = ztm;
    }

    public Float getZmoney() {
        return zmoney;
    }

    public void setZmoney(Float zmoney) {
        this.zmoney = zmoney;
    }

    public String getZtime() {
        return ztime;
    }

    public void setZtime(String ztime) {
        this.ztime = ztime;
    }

    public String getZremark() {
        return zremark;
    }

    public void setZremark(String zremark) {
        this.zremark = zremark;
    }

    @Override
    public String toString() {
        return "Myzhichu{" +
                "zid=" + zid +
                ", eid=" + eid +
                ", erealname='" + erealname + '\'' +
                ", ztm='" + ztm + '\'' +
                ", zmoney=" + zmoney +
                ", ztime='" + ztime + '\'' +
                ", zremark='" + zremark + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
