package com.ypn.entity;

import com.ypn.dao.BaseDao;

/**
 * @author ypn
 * @date 2020/8/28
 * @motto I raise pigs in your field
 * @desc 日常房屋政策实体类
 */
public class Myzc extends BaseDto {
    private  Long cid;
    private  String ctitle;
    private  String ctime;
    private  String cremark;
    public Myzc(){

    }

    public Myzc(Long cid, String ctitle, String ctime, String cremark) {
        this.cid = cid;
        this.ctitle = ctitle;
        this.ctime = ctime;
        this.cremark = cremark;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCremark() {
        return cremark;
    }

    public void setCremark(String cremark) {
        this.cremark = cremark;
    }

    @Override
    public String toString() {
        return "Myzc{" +
                "cid=" + cid +
                ", ctitle='" + ctitle + '\'' +
                ", ctime='" + ctime + '\'' +
                ", cremark='" + cremark + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
