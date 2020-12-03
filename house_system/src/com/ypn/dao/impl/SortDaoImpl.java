package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;

/**
 * @author ypn
 * @date 2020/8/16
 * @motto I raise pigs in your field
 * @desc
 */
public class SortDaoImpl extends SystemDao {
    private  String select = "select * from mysort";
    private   String sqlCount = "select count(*) from mysort";
    private  String sqlAdd="insert mysort(SNAME) values(?)";
    public String getSelect() {
        return select;
    }

    public String getSqlCount() {
        return sqlCount;
    }

    public String getSqlAdd() {
        return sqlAdd;
    }
}
