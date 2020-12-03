package com.ypn.entity;

import org.jcp.xml.dsig.internal.dom.DOMUtils;

import java.util.zip.InflaterInputStream;

/**
 * @author ypn
 * @date 2020/8/7
 * @motto I raise pigs in your field
 * @desc
 */
public class Dept  extends  BaseDto{
    private Long PID;//部门id
    private String PNAME;//部门名称
    private Long PFLAG;//0正在使用1删除
    private String PREMARK;//备注说明
//    private Integer AllCount;//所有结果数
//    private Integer AllPage;//所有页数
//    private Integer current;//当前页数
//    private Integer up;
//    private Integer next;

    public Dept() {
        super();
    }

    public Dept(Long PID, String PNAME, Long PFLAG, String PREMARK, Integer allCount, Integer allPage, Integer current, Integer up, Integer next) {
        this.PID = PID;
        this.PNAME = PNAME;
        this.PFLAG = PFLAG;
        this.PREMARK = PREMARK;
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


    public Long getPID() {
        return PID;
    }

    public void setPID(Long PID) {
        this.PID = PID;
    }

    public String getPNAME() {
        return PNAME;
    }

    public void setPNAME(String PNAME) {
        this.PNAME = PNAME;
    }

    public Long getPFLAG() {
        return PFLAG;
    }

    public void setPFLAG(Long PFLAG) {
        this.PFLAG = PFLAG;
    }

    public String getPREMARK() {
        return PREMARK;
    }

    public void setPREMARK(String PREMARK) {
        this.PREMARK = PREMARK;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "PID=" + PID +
                ", PNAME='" + PNAME + '\'' +
                ", PFLAG=" + PFLAG +
                ", PREMARK='" + PREMARK + '\'' +
                '}';
    }
}
