package com.ypn.service.Impl;

import com.ypn.dao.impl.SortDaoImpl;
import com.ypn.entity.Dept;
import com.ypn.entity.Mycus;
import com.ypn.entity.Sort;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/16
 * @motto I raise pigs in your field
 * @desc
 */
public class SortServiceImpl {
    SortDaoImpl sortDao = new SortDaoImpl();

    /**
     *添加房屋类别
     */
    public boolean addSort(Object[] sName) {
       return sortDao.add(sortDao.getSqlAdd(),sName);
    }

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return sortDao.queryRecords(sortDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return sortDao.queryCount(sortDao.getSqlCount(), null);

    }

    /**
     * List<map>封装为存放到实体类的集合(无分页)
     */
    public List<Sort> queryListTodto(Object[] objects) {
        //查询所有
        List<Map<String, Object>> list = queryRecords(objects);
        List<Sort> sorts = new ArrayList<Sort>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Sort sort = new Sort();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                sort.setSID(Long.valueOf(map.get("SID").toString()));
                sort.setSNAME((String) map.get("SNAME"));
                //添加到当前Dept对象List<Dept>中
                sorts.add(sort);
            }
        }
        return sorts;
    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Sort> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = sortDao.queryRecords(sortDao.getSelect(), pageMap, objects);
        List<Sort> sorts = new ArrayList<Sort>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Sort sort = new Sort();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                sort.setSID(Long.valueOf(map.get("SID").toString()));
                sort.setSNAME((String) map.get("SNAME"));
                //添加到当前Sort对象List<Sort>中
                sorts.add(sort);
            }
        }
        return sorts;
    }
    public boolean addCustom(Sort sort) {
        Object[] objects = new Object[]{};
        objects[0] = sort.getSNAME();
        System.out.println(objects.toString());
        return sortDao.add(sortDao.getSqlAdd(),objects);
    }
}
