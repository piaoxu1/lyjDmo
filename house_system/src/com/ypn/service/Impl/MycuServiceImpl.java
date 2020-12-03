package com.ypn.service.Impl;

import com.ypn.dao.impl.MycusDaoImpl;
import com.ypn.entity.Mycus;
import com.ypn.service.ServiceDao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/21
 * @motto I raise pigs in your field
 * @desc
 */
public class MycuServiceImpl implements ServiceDao {
    MycusDaoImpl mycusDao = new MycusDaoImpl();

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return mycusDao.queryRecords(mycusDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return mycusDao.queryCount(mycusDao.getSqlCount(), null);

    }

    public Boolean add(Object[] objects) {
        return mycusDao.add(mycusDao.getSqlAdd(), objects);
    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Mycus> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = mycusDao.queryRecords(mycusDao.getSelect(), pageMap, objects);
        List<Mycus> mycusList = new ArrayList<Mycus>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Mycus mycus = new Mycus();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                mycus.setcId(Long.valueOf(map.get("CID").toString()));
                mycus.setcName((String) map.get("CNAME"));
                mycus.setcSex((String) map.get("CSEX"));
                mycus.setcTel((String) map.get("CTEL"));
                mycus.setcTel1((String) map.get("CTEL1"));
                mycus.setcCard((String) map.get("CCARD"));
                mycusList.add(mycus);
            }
        }
        return mycusList;
    }

    public boolean addCustom(Mycus mycus) {
     if (mycus!=null){
         return mycusDao.addCustom(mycus);
     }else {
         return false;
     }
    }
}
