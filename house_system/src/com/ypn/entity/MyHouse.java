package com.ypn.entity;



/**
 * @author ypn
 * @date 2020/8/19
 * @motto I raise pigs in your field
 * @desc
 */
public class MyHouse extends BaseDto {
    private Long hid;
    private Long sid;
    private Long aid;
    private String sName;
    private String aName;
    private String hAddress;
    private String hfh;
    private String hhx;
    private String hmj;
    private String hcx;
    private Float hMoney;
    private Float hwf;
    private Float hdx;
    private Float hsf;
    private Float hmq;
    private Float dkd;
    private Float skd;
    private Float mkd;
    private String hjp;
    private String hRemark;
    private String hImg;
    private String hFlag;

    public MyHouse() {
    };

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress;
    }

    public String getHfh() {
        return hfh;
    }

    public void setHfh(String hfh) {
        this.hfh = hfh;
    }

    public String getHhx() {
        return hhx;
    }

    public void setHhx(String hhx) {
        this.hhx = hhx;
    }

    public String getHmj() {
        return hmj;
    }

    public void setHmj(String hmj) {
        this.hmj = hmj;
    }

    public String getHcx() {
        return hcx;
    }

    public void setHcx(String hcx) {
        this.hcx = hcx;
    }

    public Float gethMoney() {
        return hMoney;
    }

    public void sethMoney(Float hMoney) {
        this.hMoney = hMoney;
    }

    public Float getHwf() {
        return hwf;
    }

    public void setHwf(Float hwf) {
        this.hwf = hwf;
    }

    public Float getHdx() {
        return hdx;
    }

    public void setHdx(Float hdx) {
        this.hdx = hdx;
    }

    public Float getHsf() {
        return hsf;
    }

    public void setHsf(Float hsf) {
        this.hsf = hsf;
    }

    public Float getHmq() {
        return hmq;
    }

    public void setHmq(Float hmq) {
        this.hmq = hmq;
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

    public String getHjp() {
        return hjp;
    }

    public void setHjp(String hjp) {
        this.hjp = hjp;
    }

    public String gethRemark() {
        return hRemark;
    }

    public void sethRemark(String hRemark) {
        this.hRemark = hRemark;
    }

    public String gethImg() {
        return hImg;
    }

    public void sethImg(String hImg) {
        this.hImg = hImg;
    }

    public String gethFlag() {
        return hFlag;
    }

    public void sethFlag(String hFlag) {
        this.hFlag = hFlag;
    }

    public MyHouse(Long hid, Long sid, Long aid, String sName, String aName, String hAddress, String hfh, String hhx, String hmj, String hcx, Float hMoney, Float hwf, Float hdx, Float hsf, Float hmq, Float dkd, Float skd, Float mkd, String hjp, String hRemark, String hImg, String hFlag) {
        this.hid = hid;
        this.sid = sid;
        this.aid = aid;
        this.sName = sName;
        this.aName = aName;
        this.hAddress = hAddress;
        this.hfh = hfh;
        this.hhx = hhx;
        this.hmj = hmj;
        this.hcx = hcx;
        this.hMoney = hMoney;
        this.hwf = hwf;
        this.hdx = hdx;
        this.hsf = hsf;
        this.hmq = hmq;
        this.dkd = dkd;
        this.skd = skd;
        this.mkd = mkd;
        this.hjp = hjp;
        this.hRemark = hRemark;
        this.hImg = hImg;
        this.hFlag = hFlag;
    }

    @Override
    public String toString() {
        return "MyHouse{" +
                "hid=" + hid +
                ", sid=" + sid +
                ", aid=" + aid +
                ", sName='" + sName + '\'' +
                ", aName='" + aName + '\'' +
                ", hAddress='" + hAddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", hhx='" + hhx + '\'' +
                ", hmj='" + hmj + '\'' +
                ", hcx='" + hcx + '\'' +
                ", hMoney=" + hMoney +
                ", hwf=" + hwf +
                ", hdx=" + hdx +
                ", hsf=" + hsf +
                ", hmq=" + hmq +
                ", dkd=" + dkd +
                ", skd=" + skd +
                ", mkd=" + mkd +
                ", hjp='" + hjp + '\'' +
                ", hRemark='" + hRemark + '\'' +
                ", hImg='" + hImg + '\'' +
                ", hFlag='" + hFlag + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }


}
