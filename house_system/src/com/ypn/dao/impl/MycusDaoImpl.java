package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;
import com.ypn.entity.Mycus;

/**
 * @author ypn
 * @date 2020/8/21
 * @motto I raise pigs in your field
 * @desc
 */
public class MycusDaoImpl extends SystemDao {

    private String select = "select * from mycus";
    private String sqlAdd = "INSERT into mycus(CNAME,CSEX,CTEL,CTEL1,CCARD) VALUES(?,?,?,?,?)";
    private String sqlCount = "select count(*) from mycus";

    //    private  String sqlAdd="INSERT mycus VALUES(1,'老王','男','10086','10010','77777')";
    public String getSelect() {
        return select;
    }

    public String getSqlCount() {
        return sqlCount;
    }

    public String getSqlAdd() {
        return sqlAdd;
    }


    public boolean addCustom(Mycus mycus) {
        MycusDaoImpl mycusDao = new MycusDaoImpl();
        Object[] objects = {mycus.getcName(), mycus.getcSex(), mycus.getcTel(), mycus.getcTel1(), mycus.getcCard()};
        return mycusDao.add(mycusDao.getSqlAdd(), objects);
    }

}

