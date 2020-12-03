package com.ypn.entity;


/**
 * @author ypn
 * @date 2020/8/16
 * @motto I raise pigs in your field
 * @desc
 */
public class Area  extends  BaseDto{
    private Long AID;
    private String ANAME;
//    private Integer AllCount;//所有结果数
//    private Integer AllPage;//所有页数
//    private Integer current;//当前页数
//    private Integer up;
//    private Integer next;

    public Area(Long AID, String ANAME, Integer allCount, Integer allPage, Integer current, Integer up, Integer next) {
        this.AID = AID;
        this.ANAME = ANAME;
        AllCount = allCount;
        AllPage = allPage;
        this.current = current;
        this.up = up;
        this.next = next;
    }

    public Long getAID() {
        return AID;
    }

    public void setAID(Long AID) {
        this.AID = AID;
    }

    public String getANAME() {
        return ANAME;
    }

    public void setANAME(String ANAME) {
        this.ANAME = ANAME;
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

    public Area() {
        super();
    }

    @Override
    public String toString() {
        return "Area{" +
                "AID=" + AID +
                ", ANAME='" + ANAME + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
