package com.ypn.service.Impl;

import com.ypn.dao.impl.MyhtDaoImpl;
import com.ypn.dao.impl.MyzcDaoImpl;
import com.ypn.entity.Myht;
import com.ypn.entity.Myzc;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/28
 * @motto I raise pigs in your field
 * @desc 日常房屋政策业务层
 */
public class MyzcServiceImpl {
    MyzcDaoImpl dao = new MyzcDaoImpl();

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return dao.queryRecords(dao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return dao.queryCount(dao.getSqlCount(), null);

    }

    public Boolean add(Myzc myzc) {
        Object[] objects = {myzc.getCtitle(), myzc.getCremark()};
        return dao.add(dao.getSqlAdd(), objects);
    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Myzc> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = dao.queryRecords(dao.getSelect(), pageMap, objects);
        List<Myzc> myhts = new ArrayList<Myzc>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Myzc myht = new Myzc();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                myht.setCid(Long.valueOf(map.get("CID").toString()));
                myht.setCremark((String) map.get("CREMARK"));
                myht.setCtime((String) map.get("CTIME"));
                myht.setCtitle((String) map.get("CTITLE"));
//                myht.set((String) map.get("CTITLE"));
                myhts.add(myht);
            }
        }
        return myhts;
    }

    public List<Myzc> queryLimit(Map<String, Object> map) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException {
        return dao.query(dao.getSelect(), null, map, Myzc.class);
    }
}
