package com.ypn.service.Impl;

import com.ypn.dao.impl.MyhtDaoImpl;
import com.ypn.dao.impl.MyzhichuDaoImpl;
import com.ypn.entity.Myht;
import com.ypn.entity.Myzhichu;
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
public class MyhtServiceImpl implements ServiceDao {
    MyhtDaoImpl myhtDao = new MyhtDaoImpl();

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return myhtDao.queryRecords(myhtDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return myhtDao.queryCount(myhtDao.getSqlCount(), null);

    }

    public Boolean add(Object[] objects) {
        return myhtDao.add(myhtDao.getSqlAdd(), objects);
    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Myht> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = myhtDao.queryRecords(myhtDao.getSelect(), pageMap, objects);
        List<Myht>  myhts = new ArrayList<Myht>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Myht myht = new Myht();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                myht.setHtid(Long.valueOf(map.get("HTID").toString()));
                myht.setHtname((String) map.get("HTNAME"));
                myht.setHtremark((String) map.get("HTREMARK"));
                myhts.add(myht);
            }
        }
        return myhts;
    }
}
