package com.ypn.entity;


/**
 * @author ypn
 * @date 2020/8/15
 * @motto I raise pigs in your field
 * @desc
 */
public class Js  extends BaseDto{
    private Long JID;
    private String JNAME;
//    private Integer AllCount;//所有结果数
//    private Integer AllPage;//所有页数
//    private Integer current;//当前页数
//    private Integer up;
//    private Integer next;
    public Js() {
        super();
    }

    public Js(Long JID, String JNAME, Integer allCount, Integer allPage, Integer current, Integer up, Integer next) {
        this.JID = JID;
        this.JNAME = JNAME;
        AllCount = allCount;
        AllPage = allPage;
        this.current = current;
        this.up = up;
        this.next = next;
    }



    public Long getJID() {
        return JID;
    }

    public void setJID(Long JID) {
        this.JID = JID;
    }

    public String getJNAME() {
        return JNAME;
    }

    public void setJNAME(String JNAME) {
        this.JNAME = JNAME;
    }

    @Override
    public String toString() {
        return "Js{" +
                "JID=" + JID +
                ", JNAME='" + JNAME + '\'' +
                '}';
    }
}
