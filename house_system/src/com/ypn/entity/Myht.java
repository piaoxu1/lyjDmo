package com.ypn.entity;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class Myht extends  BaseDto {
    private Long htid;
    private String htname;
    private String htremark;

    public Myht(){}
    public Myht(Long htid, String htname, String htremark) {
        this.htid = htid;
        this.htname = htname;
        this.htremark = htremark;
    }

    public Long getHtid() {
        return htid;
    }

    public void setHtid(Long htid) {
        this.htid = htid;
    }

    public String getHtname() {
        return htname;
    }

    public void setHtname(String htname) {
        this.htname = htname;
    }

    public String getHtremark() {
        return htremark;
    }

    public void setHtremark(String htremark) {
        this.htremark = htremark;
    }

    @Override
    public String toString() {
        return "Myht{" +
                "htid=" + htid +
                ", htname='" + htname + '\'' +
                ", htremark='" + htremark + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
