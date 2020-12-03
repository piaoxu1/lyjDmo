package com.ypn.service.Impl;

import com.ypn.dao.impl.JsDaoImpl;
import com.ypn.entity.Dept;
import com.ypn.entity.Js;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/15
 * @motto I raise pigs in your field
 * @desc
 */
public class JsServiceImpl {
    JsDaoImpl jsDao = new JsDaoImpl();
   private static String sqlLimit = "select * from myjs ";
    /**
     * 查询(不分页)
     *
     * @param objects
     * @return
     */
    public List<Map<String, Object>> queryRecords(Object[] objects) {
        String queryAll = "select * from myjs where 1=1";
        return jsDao.queryRecords(queryAll, objects);
    }

    /**
     * 增加
     *
     * @param objects
     */
    public Boolean add(Object[] objects) {
        String sql = "insert myjs(JNAME) values(?)";
       return jsDao.add(sql, objects);
    }
    /**
     * 修改
     *
     * @param objects
     */
    public void update(Object[] objects) {
        String sql = "update myjs set JID=?,JNAME=? WHERE JID=?";
        jsDao.add(sql, objects);
    }
    /**
     * 删除
     *
     * @param objects
     */
    public void delete(Object[] objects) {
        String sql = "delete from myjs where JID=?";
        jsDao.add(sql, objects);
    }


    /**
     * 获取列的总数
     */
    public Integer queryCount(Object[] objects) {
        String sql = "select count(*) from myjs";
        return jsDao.queryCount(sql, objects);
    }

    /**
     * List<map>转为实体类(无分页)
     */
    public List<Js> queryListTodto(Object[] objects) {
        List<Map<String, Object>> list = queryRecords(objects);
        List<Js> js = new ArrayList<Js>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Js js1 = new Js();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                js1.setJID(Long.valueOf(map.get("JID").toString()));
                js1.setJNAME((String) map.get("JNAME"));
                //添加到当前Js对象List<Js>中
                js.add(js1);
            }
        }
        return js;
    }
    /**
     * 通用查询（支持分页）
     */
    public List<Js> queryLimit(Map<String,Object> map, Object[] objects){
        List<Map<String,Object>> list = jsDao.queryRecords(sqlLimit,map,objects);
        List<Js> js = new ArrayList<Js>();
        //当查询有结果的时候
        if (list!=null&&!list.isEmpty()){
            for (int i=0;i<list.size();i++){
                Js js1 = new Js();
                //获取当前下标的数据
                Map<String, Object> map1 = list.get(i);
                js1.setJID(Long.valueOf(map1.get("JID").toString()));
                js1.setJNAME((String) map1.get("JNAME"));
                //添加到当前Js对象List<Js>中
                js.add(js1);
            }
        }
        return js;
    }

//    public static void main(String[] args) {
//        JsServiceImpl jsService = new JsServiceImpl();
//        Map<String,Object> map  = new HashMap<>();
//        System.out.println(jsService.queryLimit(map,null).toString());
//    }
}
