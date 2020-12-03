package com.ypn.service.Impl;

import com.ypn.dao.impl.EmpDaoImpl;
import com.ypn.dao.impl.JsDaoImpl;
import com.ypn.entity.Emp;
import com.ypn.entity.Js;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/15
 * @motto I raise pigs in your field
 * @desc
 */
public class EmpServiceImpl {
    EmpDaoImpl empDao = new EmpDaoImpl();
    private String sqlLimit = "select * from myemp,mydept,myjs WHERE myemp.PID=mydept.PID AND myemp.JID=myjs.JID";
    private String sqlAdd = "INSERT myemp(PID,JID,ENAME,EPSW,EREALNAME,ETEL,EADDRESS,EFLAG,EREMARK) \n" +
            "VALUES(?,?,?,?,?,?,?,0,?)";

    /**
     * 修改密码
     */
    public boolean update(Object[] objects) {
        String sql = "update myemp set EPSW=? WHERE ENAME=?";
        return empDao.add(sql, objects);
    }

    //    ,EPSW,EREALNAME,ETEL,EADDRESS,EFLAG,EREMARK
    public boolean add(Emp emp) {
        Object[] objects =new Object[8];
        objects[0] = emp.getPID();
        objects[1] = emp.getJID();
        objects[2] = emp.getENAME();
        objects[3] = emp.getEPSW();
        objects[4] = emp.getEREALNAME();
        objects[5] = emp.getETEL();
        objects[6] = emp.getEADDRESS();
        objects[7] = emp.getEREMARK();
        return empDao.add(sqlAdd, objects);
    }

    /**
     * 通过用户名查对应密码
     */
    public String selectPwd(Object[] o) {
        String sql = "select * from myemp where ENAME=?";
        List<Map<String, Object>> list = empDao.queryRecords(sql, o);
        String pwd = "";
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Emp emp = new Emp();
                System.out.println(list.size());
                Map<String, Object> map = list.get(i);
                emp.setEPSW((String) map.get("EPSW"));
                pwd = emp.getEPSW();
            }
        }
        return pwd;
    }

    /**
     * 通用查询
     *
     * @param objects
     * @return
     */
    public List<Map<String, Object>> queryRecords(Object[] objects) {
        String queryAll = "select * from myemp,mydept,myjs WHERE myemp.PID=mydept.PID AND myemp.JID=myjs.JID";
        return empDao.queryRecords(queryAll, objects);
    }

    /**
     * 增加
     *
     * @param objects
     */
//    public void add(Object[] objects) {
//        String sql = "insert emp values(?,?,?,?,?,?,?,?,?,?)";
//        empDao.add(sql, objects);
//    }

    /**
     * 删除
     *
     * @param objects
     */
    public void delete(Object[] objects) {
        String sql = "delete from myjs where EID=?";
        empDao.add(sql, objects);
    }


    /**
     * 获取列的总数
     */
    public Integer queryCount(Object[] objects) {
        String sql = "select count(*) from myemp";
        return empDao.queryCount(sql, objects);
    }

    /**
     * List<map>转为实体类
     */
    public List<Emp> queryListTodto(Object[] objects) {
        List<Map<String, Object>> list = queryRecords(objects);
        List<Emp> emps = new ArrayList<Emp>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Emp emp = new Emp();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                emp.setEID(Long.valueOf(map.get("EID").toString()));
                emp.setPID(Long.valueOf(map.get("PID").toString()));
                emp.setJID(Long.valueOf(map.get("JID").toString()));
                emp.setENAME((String) map.get("ENAME"));
                emp.setEPSW((String) map.get("EPSW"));
                emp.setEREALNAME((String) map.get("EREALNAME"));
                emp.setETEL((String) map.get("ETEL"));
                emp.setEADDRESS((String) map.get("EADDRESS"));
                emp.setEFLAG(Long.valueOf(map.get("EFLAG").toString()));
                emp.setEREMARK((String) map.get("EREMARK"));
                emp.setPNAME((String) map.get("PNAME"));
                emp.setJNAME((String) map.get("JNAME"));
                //添加到当前Js对象List<Emp>中
                emps.add(emp);
            }
        }
        return emps;
    }

    /**
     * List<map>转为实体类
     */
    public List<Emp> queryLimit(Map<String, Object> PageMap, Object[] objects) {

        List<Map<String, Object>> list = empDao.queryRecords(sqlLimit, PageMap, objects);
        List<Emp> emps = new ArrayList<Emp>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Emp emp = new Emp();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                emp.setEID(Long.valueOf(map.get("EID").toString()));
                emp.setPID(Long.valueOf(map.get("PID").toString()));
                emp.setJID(Long.valueOf(map.get("JID").toString()));
                emp.setENAME((String) map.get("ENAME"));
                emp.setEPSW((String) map.get("EPSW"));
                emp.setEREALNAME((String) map.get("EREALNAME"));
                emp.setETEL((String) map.get("ETEL"));
                emp.setEADDRESS((String) map.get("EADDRESS"));
                emp.setEFLAG(Long.valueOf(map.get("EFLAG").toString()));
                emp.setEREMARK((String) map.get("EREMARK"));
                emp.setPNAME((String) map.get("PNAME"));
                emp.setJNAME((String) map.get("JNAME"));
                //添加到当前Js对象List<Emp>中
                emps.add(emp);
            }
        }
        return emps;
    }
}
