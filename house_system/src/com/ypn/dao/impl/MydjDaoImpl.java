package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;

/**
 * @author ypn
 * @date 2020/8/22
 * @motto I raise pigs in your field
 * @desc 登记入住dao
 */
public class MydjDaoImpl extends SystemDao {
    private String select = null;

    private String sqlCount = null;

    private String addSql = null;

    public String getSelect() {
        return "SELECT * from mydj,myemp,mycus,myhouse WHERE mydj.EID=myemp.EID AND mydj.CID=mycus.CID AND mydj.HID=myhouse.HID";
    }

    public String getSqlCount() {
        return "select count(*) from mydj";
    }

    public String getAddSql() {
        return "INSERT mydj(MDATE,EID,CID,HID,MYJ,MYZJ,MBEGintIME) VALUES (now(),2,?,?,?,?,?)";
    }
}
