package com.ypn.service.Impl;

import com.ypn.dao.impl.DeptDaoImpl;
import com.ypn.entity.Dept;


import java.util.*;

/**
 * @author ypn
 * @date 2020/8/11
 * @motto I raise pigs in your field
 * @desc
 */
public class DeptServiceImpl   {
    private static String sql = "select * from mydept where 1 = 1";
    private static String sql1 = "INSERT mydept(PID,PNAME,PFLAG,PREMARK) VALUES (?,?,?,?)";
    private static String sql2 ="delete from mydept where PID =?";
    private static  String sql3 ="update mydept set PID=?,PNAME=?,PFLAG=?,PREMARK=? WHERE PID=?";
    private static   String limitSql="select * from mydept";
    private String countSql= "select count(*) from mydept";
    private  String sqlAdd="insert mydept(PNAME,PFLAG,PREMARK) values(?,0,?)";
    static DeptDaoImpl deptDao = new DeptDaoImpl();

    /**
     * 通用查询
     *
     * @param sql
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(String sql, Object[] objects) {
        return deptDao.queryRecords(sql, objects);
    }

    /**
     * 增加  删除  修改的通用方法
     * @param
     * @param objects
     */
    public final Boolean add( Object[] objects) {
        return  deptDao.add(sqlAdd, objects);
    }

/**
 * 获取列的总数
 */
    public Integer queryCount(Object[] objects){
        Integer count = 0;
        count=deptDao.queryCount(countSql,objects);
        return count;
    }
    /**
     * List<map>转为实体类
     */
    public List<Dept> queryListTodto(Object[] objects){
        //查询所有
        List<Map<String,Object>> list = queryRecords(sql,objects);
        List<Dept> depts = new ArrayList<Dept>();
        //当查询有结果的时候
        if (list!=null&&!list.isEmpty()){
            for (int i=0;i<list.size();i++){
                Dept dept  = new Dept();
                //获取当前下标的数据
                Map<String,Object> map = list.get(i);
                dept.setPID((Long) map.get("PID"));
                dept.setPNAME((String) map.get("PNAME"));
                dept.setPFLAG((Long) map.get("PFLAG"));
                dept.setPREMARK((String) map.get("PREMARK"));
                //添加到当前Dept对象List<Dept>中
                depts.add(dept);
            }
        }
        return depts;
    }

    /**
     * 通用查询（支持分页）
     */
    public List<Dept> queryLimit(Map<String,Object> map,Object[] objects){
        List<Map<String,Object>> list = deptDao.queryRecords(limitSql,map,objects);
        List<Dept> depts = new ArrayList<Dept>();
        //当查询有结果的时候
        if (list!=null&&!list.isEmpty()){
            for (int i=0;i<list.size();i++){
                Dept dept  = new Dept();
                //获取当前下标的数据
                Map<String,Object> map1 = list.get(i);
                dept.setPID(Long.valueOf(map1.get("PID").toString()));
                dept.setPNAME((String) map1.get("PNAME"));
                dept.setPFLAG(Long.valueOf(map1.get("PFLAG").toString()));
                dept.setPREMARK((String) map1.get("PREMARK"));
                //把当前Dept对象添加到List<Dept>中
                depts.add(dept);
            }
        }
        return depts;
    }

/**
 * 测试
 */
//public static void main(String[] args) {
//    DeptServiceImpl i =  new DeptServiceImpl();
//    Map<String,Object> map = new HashMap<>();
//    System.out.println(i.queryLimit(map,null).toString());
//    System.out.println(i.queryCount(null));
//}
    /**
     * 测试
     *
     * @param args
     */
//    public static void main(String[] args) {
//        //测试添加
////        Object[] o = {6, "test部", 1, "测试数据2，可删除"};
////        DeptServiceImpl.add(sql1, o);
//        //测试删除
////         Object[] o1 ={6};
////        DeptServiceImpl.add(sql2,o1);
//        //测试修改
////        Object[] o2 = {5,"财务部",1,"这是测试数据",5};
//        DeptServiceImpl deptService = new DeptServiceImpl();
////               deptService.add(sql3,o2);
//        //测试查询
//        Object[] objects = new Object[]{};
//        List list = deptService.queryRecords(sql, objects);
//        System.out.println(list.toString());
//        //测试查询
//        int i = deptService.queryCount("select count(*) from mydept",objects);
//        System.out.println("列数：" + i);
//    }


}
