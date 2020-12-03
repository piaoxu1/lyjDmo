package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MysfDaoImpl extends SystemDao {
    private  String select = null;

    private   String sqlCount = null;

    public String getSelect() {
        return "select * from Mysf,mydj,myemp,myhouse,mycus where mysf.EID=myemp.EID AND Mysf.MID=mydj.MID AND mydj.HID=myhouse.HID AND mydj.CID=mycus.CID" ;
    }

    public String getSqlCount() {
        return "select count(*) from mysf";
    }


}
