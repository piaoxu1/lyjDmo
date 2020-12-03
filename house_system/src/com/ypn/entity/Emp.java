package com.ypn.entity;


/**
 * @author ypn
 * @date 2020/8/15
 * @motto I raise pigs in your field
 * @desc
 */
public class Emp extends BaseDto {
    private Long EID;
    private Long PID;
    private Long JID;
    private String ENAME;
    private String EPSW;
    private String EREALNAME;
    private String ETEL;
    private String EADDRESS;
    private Long EFLAG;
    private String EREMARK;
    private String PNAME;
    private String JNAME;
//    private Integer AllCount;//所有结果数
//    private Integer AllPage;//所有页数
//    private Integer current;//当前页数
//    private Integer up;
//    private Integer next;

    public Emp() {
        super();
    }

    public Emp(Long EID, Long PID, Long JID, String ENAME, String EPSW, String EREALNAME, String ETEL, String EADDRESS, Long EFLAG, String EREMARK, String PNAME, String JNAME, Integer allCount, Integer allPage, Integer current, Integer up, Integer next) {
        this.EID = EID;
        this.PID = PID;
        this.JID = JID;
        this.ENAME = ENAME;
        this.EPSW = EPSW;
        this.EREALNAME = EREALNAME;
        this.ETEL = ETEL;
        this.EADDRESS = EADDRESS;
        this.EFLAG = EFLAG;
        this.EREMARK = EREMARK;
        this.PNAME = PNAME;
        this.JNAME = JNAME;
        AllCount = allCount;
        AllPage = allPage;
        this.current = current;
        this.up = up;
        this.next = next;
    }

//    public Integer getAllCount() {
//        return AllCount;
//    }
//
//    public void setAllCount(Integer allCount) {
//        AllCount = allCount;
//    }
//
//    public Integer getAllPage() {
//        return AllPage;
//    }
//
//    public void setAllPage(Integer allPage) {
//        AllPage = allPage;
//    }
//
//    public Integer getCurrent() {
//        return current;
//    }
//
//    public void setCurrent(Integer current) {
//        this.current = current;
//    }
//
//    public Integer getUp() {
//        return up;
//    }
//
//    public void setUp(Integer up) {
//        this.up = up;
//    }
//
//    public Integer getNext() {
//        return next;
//    }
//
//    public void setNext(Integer next) {
//        this.next = next;
//    }

    public String getPNAME() {
        return PNAME;
    }

    public void setPNAME(String PNAME) {
        this.PNAME = PNAME;
    }

    public String getJNAME() {
        return JNAME;
    }

    public void setJNAME(String JNAME) {
        this.JNAME = JNAME;
    }

    public Long getEID() {
        return EID;
    }

    public void setEID(Long EID) {
        this.EID = EID;
    }

    public Long getPID() {
        return PID;
    }

    public void setPID(Long PID) {
        this.PID = PID;
    }

    public Long getJID() {
        return JID;
    }

    public void setJID(Long JID) {
        this.JID = JID;
    }

    public String getENAME() {
        return ENAME;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public String getEPSW() {
        return EPSW;
    }

    public void setEPSW(String EPSW) {
        this.EPSW = EPSW;
    }

    public String getEREALNAME() {
        return EREALNAME;
    }

    public void setEREALNAME(String EREALNAME) {
        this.EREALNAME = EREALNAME;
    }

    public String getETEL() {
        return ETEL;
    }

    public void setETEL(String ETEL) {
        this.ETEL = ETEL;
    }

    public String getEADDRESS() {
        return EADDRESS;
    }

    public void setEADDRESS(String EADDRESS) {
        this.EADDRESS = EADDRESS;
    }

    public Long getEFLAG() {
        return EFLAG;
    }

    public void setEFLAG(Long EFLAG) {
        this.EFLAG = EFLAG;
    }

    public String getEREMARK() {
        return EREMARK;
    }

    public void setEREMARK(String EREMARK) {
        this.EREMARK = EREMARK;
    }
}
