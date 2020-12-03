package com.ypn.service.Impl;

import com.ypn.dao.impl.MybiaoDaoImpl;
import com.ypn.dao.impl.MydjDaoImpl;
import com.ypn.entity.Mybiao;
import com.ypn.entity.Mydj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MybiaoServiceImpl  {
    MybiaoDaoImpl mybiaoDao = new MybiaoDaoImpl();

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return mybiaoDao.queryRecords(mybiaoDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return mybiaoDao.queryCount(mybiaoDao.getSqlCount(), null);

    }

    public Boolean add(Object[] objects) {
        return mybiaoDao.add(mybiaoDao.getSqlAdd(), objects);
    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Mybiao> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = mybiaoDao.queryRecords(mybiaoDao.getSelect(), pageMap, objects);
        List<Mybiao> mybiaoList = new ArrayList<Mybiao>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Mybiao mybiao = new Mybiao();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                mybiao.setBid(Long.valueOf(map.get("BID").toString()));
                mybiao.setHid(Long.valueOf(map.get("HID").toString()));
                mybiao.setEid(Long.valueOf(map.get("EID").toString()));
                mybiao.setEname((String) map.get("EREALNAME"));
                mybiao.setHaddress((String) map.get("HADDRESS"));
                mybiao.setHfh((String) map.get("HFH"));
                mybiao.setDkd((Float) map.get("DKD"));
                mybiao.setSkd((Float) map.get("SKD"));
                mybiao.setMkd((Float) map.get("MKD"));
                mybiao.setMtime((String) map.get("MTIME"));
                mybiaoList.add(mybiao);
            }
        }
        return mybiaoList;
    }
}
