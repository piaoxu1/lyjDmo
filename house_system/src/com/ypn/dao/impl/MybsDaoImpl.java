package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MybsDaoImpl extends SystemDao {
    private  String select = "SELECT * from mybs,myhouse,myemp where mybs.HID=myhouse.HID AND mybs.EID=myemp.EID";
    private   String sqlCount = "select count(*) from mybs";
     private  String sqlAdd=null;

    public String getSelect() {
        return select;
    }

    public String getSqlAdd() {
        return "INSERT mybs(HID,MTIME,BREMARK,EID)\n" +
                "VALUES(?,now(),?,1)";
    }

    public String getSqlCount() {
        return sqlCount;
    }

}
