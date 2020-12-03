package com.ypn.entity;



/**
 * @author ypn
 * @date 2020/8/16
 * @motto I raise pigs in your field
 * @desc
 */
public class Sort  extends BaseDto {
    private Long SID;
    private  String SNAME;


    public Sort() {
        super();
    }



    public Long getSID() {
        return SID;
    }

    public void setSID(Long SID) {
        this.SID = SID;
    }

    public String getSNAME() {
        return SNAME;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = SNAME;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "SID=" + SID +
                ", SNAME='" + SNAME + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
