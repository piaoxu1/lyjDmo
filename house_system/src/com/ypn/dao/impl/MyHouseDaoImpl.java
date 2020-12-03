package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;


/**
 * @author ypn
 * @date 2020/8/19
 * @motto I raise pigs in your field
 * @desc   房屋dao
 */
public class MyHouseDaoImpl extends SystemDao {
    private String select = "select * from myhouse,myarea,mysort WHERE myhouse.SID=mysort.SID AND myarea.AID=myhouse.AID";
    private String sqlCount = "select count(*) from myhouse";
    private String select1 = null;
    private String sqlAdd=null;
    private String sqlAdd1=null;
    public String getSelect() {
        return select;
    }

    public String getSqlCount() {
        return sqlCount;
    }

    public String getSqlAdd1() {
        return "INSERT myhouse(SKD,MKD,DKD) VALUES (?,?,?)";
    }

    public String getSqlAdd() {
        return "INSERT myhouse(SID,AID,HADDRESS,HFH,HHX,HMJ,HCX,HMONEY,HWF,HDX,HSF,HMQ,DKD,SKD,MKD,HJP,HREMARK,HIMG,HFLAG)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'0','1')";
    }

    public String getSelect1() {
        return "select myhouse.HID hid,SNAME sname,ANAME aname,HADDRESS hAddress,HFH hfh,HHX hhx,HMJ hmj,HCX hcx ,HMONEY hMoney,HFLAG hFlag from myhouse,myarea,mysort WHERE myhouse.SID=mysort.SID AND myarea.AID=myhouse.AID AND HFLAG=?  AND myhouse.AID=?  AND myhouse.SID =? ";
    }
}
