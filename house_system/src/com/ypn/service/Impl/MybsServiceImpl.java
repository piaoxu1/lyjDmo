package com.ypn.service.Impl;

import com.ypn.dao.impl.MybiaoDaoImpl;
import com.ypn.dao.impl.MybsDaoImpl;
import com.ypn.entity.Mybiao;
import com.ypn.entity.Mybs;
import com.ypn.service.ServiceDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MybsServiceImpl implements ServiceDao {
    MybsDaoImpl mybsDao = new MybsDaoImpl();

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return mybsDao.queryRecords(mybsDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return mybsDao.queryCount(mybsDao.getSqlCount(), null);

    }

    public Boolean add(Object[] objects) {
        return mybsDao.add(mybsDao.getSqlAdd(), objects);
    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Mybs> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = mybsDao.queryRecords(mybsDao.getSelect(), pageMap, objects);
        List<Mybs> mybsList = new ArrayList<Mybs>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Mybs mybs = new Mybs();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                mybs.setBid(Long.valueOf(map.get("BID").toString()));
                mybs.setHid(Long.valueOf(map.get("HID").toString()));
                mybs.setEid(Long.valueOf(map.get("EID").toString()));
                mybs.setHaddress((String) map.get("HADDRESS"));
                mybs.setHfh((String) map.get("HFH"));
                mybs.setMtime((String) map.get("MTIME"));
                mybs.setBremark((String) map.get("BREMARK"));
                mybs.setErealname((String) map.get("EREALNAME"));
                mybsList.add(mybs);
            }
        }
        return mybsList;
    }
}
