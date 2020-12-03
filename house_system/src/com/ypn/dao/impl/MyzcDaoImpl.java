package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;

/**
 * @author ypn
 * @date 2020/8/28
 * @motto I raise pigs in your field
 * @desc 日常房屋政策dao
 */
public class MyzcDaoImpl extends SystemDao {
    private  String select = null;

    private   String sqlCount = null;
    private  String sqlAdd=null;

    public String getSelect() {
        return "select * from myzc" ;
    }

    public String getSqlCount() {
        return "select count(*) from myzc";
    }

    public String getSqlAdd() {
        return "INSERT myzc(CTITLE,CTIME,CREMARK) VALUES(?,now(),?)";
    }

}
