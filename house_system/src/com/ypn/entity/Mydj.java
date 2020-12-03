package com.ypn.entity;

/**
 * @author ypn
 * @date 2020/8/22
 * @motto I raise pigs in your field
 * @desc 登记入住实体类
 */
public class Mydj extends BaseDto {
    private Long mid;    //	编号
    private String mdate;//	登记时间
    private Long eid;    //经办人编号（员工编号）
    private Long cid;    //客户编号
    private String cname;    //客户编号
    private Long hid;    //房屋编号
    private String mimg; //合同图片
    private Float myj;   //押金
    private Float myzj; //预收押金
    private Long mflag;  //正在出租中为0，退租为1
    private String mbegintime;    //下次收租日期
    private  String ename;        //经办人姓名（员工姓名）
    private String ctel;           //客户电话
    private String haddress;             //房屋地址
    private String hfh;

    public Mydj(){};

    public Mydj(Long mid, String mdate, Long eid, Long cid, Long hid, String mimg, Float myj, Float myzj, Long mflag, String mbegintime, String ename, String ctel, String haddress, String hfh) {
        this.mid = mid;
        this.mdate = mdate;
        this.eid = eid;
        this.cid = cid;
        this.hid = hid;
        this.mimg = mimg;
        this.myj = myj;
        this.myzj = myzj;
        this.mflag = mflag;
        this.mbegintime = mbegintime;
        this.ename = ename;
        this.ctel = ctel;
        this.haddress = haddress;
        this.hfh = hfh;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public Float getMyj() {
        return myj;
    }

    public void setMyj(Float myj) {
        this.myj = myj;
    }

    public Float getMyzj() {
        return myzj;
    }

    public void setMyzj(Float myzj) {
        this.myzj = myzj;
    }

    public Long getMflag() {
        return mflag;
    }

    public void setMflag(Long mflag) {
        this.mflag = mflag;
    }

    public String getMbegintime() {
        return mbegintime;
    }

    public void setMbegintime(String mbegintime) {
        this.mbegintime = mbegintime;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
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
}
