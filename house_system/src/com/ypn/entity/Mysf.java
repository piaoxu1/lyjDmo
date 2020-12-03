package com.ypn.entity;

/**
 * @author ypn
 * @date 2020/8/22
 * @motto I raise pigs in your field
 * @desc
 */
public class Mysf extends BaseDto {
    private Long yid;//编号   Mysf
    private String haddress;//房屋地址  myhouse
    private String hfh;//房号           myhouse
    private Long mid;//入住编号          mydj
    private String cname;        //客户姓名   mycus
    private  String ctel;//客户电话   mycus
    private String mdate;//登记时间   mydj
    private Long eid;//经办人编号（员工编号） myemp
    private Float myzj;  // 预收租金
    private String mbegintime;//下次收租时间 Mysf
    public Mysf(){

    }

    public Mysf(Long yid, String haddress, String hfh, Long mid, String cname, String ctel, String mdate, Long eid, Float myzj, String mbegintime) {
        this.yid = yid;
        this.haddress = haddress;
        this.hfh = hfh;
        this.mid = mid;
        this.cname = cname;
        this.ctel = ctel;
        this.mdate = mdate;
        this.eid = eid;
        this.myzj = myzj;
        this.mbegintime = mbegintime;
    }

    @Override
    public String toString() {
        return "Mysf{" +
                "yid=" + yid +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", mid=" + mid +
                ", cname='" + cname + '\'' +
                ", ctel='" + ctel + '\'' +
                ", mdate='" + mdate + '\'' +
                ", eid=" + eid +
                ", myzj=" + myzj +
                ", mbegintime='" + mbegintime + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }

    public Long getYid() {
        return yid;
    }

    public void setYid(Long yid) {
        this.yid = yid;
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

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Float getMyzj() {
        return myzj;
    }

    public void setMyzj(Float myzj) {
        this.myzj = myzj;
    }

    public String getMbegintime() {
        return mbegintime;
    }

    public void setMbegintime(String mbegintime) {
        this.mbegintime = mbegintime;
    }
}
