package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;
import com.ypn.until.SystemStringUtils;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MyzhichuDaoImpl extends SystemDao {
    private String select = null;

    private String sqlCount = null;
    private String addSql=null;

    public String getAddSql() {
        return "INSERT myzhichu(EID,ZMONEY,ZTM,ZTIME,ZREMARK) VALUES(2,?,?,"+ "now()" +",?)";
    }

    public String getSelect() {
        return "select ZID AS zid,myzhichu.EID AS eid, ZMONEY AS zmoney,ZTM AS ztm,ZTIME AS ztime,ZREMARK AS zremark,ENAME as ename ,\n" +
                "EPSW AS epsw ,EREALNAME AS erealname,ETEL AS etel,EADDRESS AS eaddress,EFLAG AS eflag,EREMARK AS eremark\n" +
                "from myzhichu,myemp where myzhichu.EID=myemp.EID";
    }

    public String getSqlCount() {
        return "select count(*) from myzhichu";
    }

}
