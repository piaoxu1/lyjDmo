package com.ypn.dao.impl;

import com.ypn.dao.SystemDao;
import com.ypn.until.SystemStringUtils;

import javax.swing.*;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MyshouruDao extends SystemDao {
    private String select = null;
    private String select1 = null;
    private String sqlCount = null;
    private String addSql = null;

    public String getSelect1() {
        return "select SID AS sid,myemp.EID AS eid, SMONEY AS smoney,STM AS stm,STIME AS stime,SREMARK AS sremark,PID as pid,JID as jid,ENAME as ename ,\n" +
                "EPSW AS epsw ,EREALNAME AS erealname,ETEL AS etel,EADDRESS AS eaddress,EFLAG AS eflag,EREMARK AS eremark\n" +
                "from myshouru,myemp where myshouru.EID=myemp.EID";
}

    public String getAddSql() {
        return "INSERT myshouru (EID,SMONEY,STM,STIME,SREMARK) VALUES(2,?,?,"+ "now()" +",?)";
    }

    public String getSelect() {
        return "select * from myshouru,myemp where myshouru.EID=myemp.EID";
    }

    public String getSqlCount() {
        return "select count(*) from myshouru";
    }

}
