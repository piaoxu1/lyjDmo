package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MybiaoDaoImpl extends SystemDao {
    private  String select = null;

    private   String sqlCount = null;
    private  String sqlAdd=null;

    public String getSqlAdd() {
        return "INSERT mybiao(HID,DKD,SKD,MKD,MTIME,EID)\n" +
                "VALUES(?,?,?,?,NOW(),2)";
    }

    public String getSelect() {
        return "SELECT * FROM mybiao,myemp,myhouse where mybiao.EID = myemp.EID AND mybiao.HID=myhouse.HID" ;
    }

    public String getSqlCount() {
        return "select count(*) from mybiao";
    }


}
