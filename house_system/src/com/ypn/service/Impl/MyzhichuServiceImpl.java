package com.ypn.service.Impl;

import com.ypn.dao.impl.MyshouruDao;
import com.ypn.dao.impl.MyzhichuDaoImpl;
import com.ypn.entity.Myshouru;
import com.ypn.entity.Myzhichu;
import com.ypn.service.ServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc 日常房屋支出信息业务层
 */
public class MyzhichuServiceImpl implements ServiceDao {
    MyzhichuDaoImpl myzhichuDao = new MyzhichuDaoImpl();

    public boolean add(Myzhichu myzhichu) {
        Object[] objects = {myzhichu.getZmoney(),myzhichu.getZtm(),myzhichu.getZremark()};
        return myzhichuDao.add(myzhichuDao.getAddSql(), objects);
    }

    public List<Myzhichu> query(Object[] objects, Map<String, Object> map) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException {
        return myzhichuDao.query(myzhichuDao.getSelect(), objects, map, Myzhichu.class);
    }

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return myzhichuDao.queryRecords(myzhichuDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return myzhichuDao.queryCount(myzhichuDao.getSqlCount(), null);

    }

//    public Boolean add(Object[] objects) {
//        return mydjDao.add(mydjDao.getSqlAdd(), objects);
//    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Myzhichu> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = myzhichuDao.queryRecords(myzhichuDao.getSelect(), pageMap, objects);
        List<Myzhichu> myzhichus = new ArrayList<Myzhichu>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Myzhichu myzhichu = new Myzhichu();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                myzhichu.setZid(Long.valueOf(map.get("ZID").toString()));
                myzhichu.setEid(Long.valueOf(map.get("EID").toString()));
                myzhichu.setErealname((String) map.get("EREALNAME"));
                myzhichu.setZmoney((Float) map.get("ZMONEY"));
                myzhichu.setZtm((String) map.get("ZTM"));
                myzhichu.setZtime((String) map.get("ZTIME"));
                myzhichu.setZremark((String) map.get("ZREMARK"));
                myzhichus.add(myzhichu);
            }
        }
        return myzhichus;
    }
}
