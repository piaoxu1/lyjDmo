package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MyhtDaoImpl extends SystemDao {
    private  String select = null;

    private   String sqlCount = null;
    private  String sqlAdd=null;

    public String getSelect() {
        return "select * from myht" ;
    }

    public String getSqlCount() {
        return "select count(*) from myht";
    }

    public String getSqlAdd() {
        return "insert myht(HTNAME) values(?)";
    }
}
