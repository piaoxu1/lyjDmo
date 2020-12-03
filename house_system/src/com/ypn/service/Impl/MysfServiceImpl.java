package com.ypn.service.Impl;

import com.ypn.dao.impl.MydjDaoImpl;
import com.ypn.dao.impl.MysfDaoImpl;
import com.ypn.entity.Mydj;
import com.ypn.entity.Mysf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MysfServiceImpl  {
    MysfDaoImpl mysfDao = new MysfDaoImpl();

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return mysfDao.queryRecords(mysfDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return mysfDao.queryCount(mysfDao.getSqlCount(), null);

    }

//    public Boolean add(Object[] objects) {
//        return mydjDao.add(mydjDao.getSqlAdd(), objects);
//    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Mysf> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = mysfDao.queryRecords(mysfDao.getSelect(), pageMap, objects);
        List<Mysf> mysfList = new ArrayList<Mysf>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Mysf mysf = new Mysf();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                mysf.setMid(Long.valueOf(map.get("MID").toString()));
                mysf.setYid(Long.valueOf(map.get("YID").toString()));
                mysf.setHaddress((String) map.get("HADDRESS"));
                mysf.setHfh((String) map.get("HFH"));
                mysf.setCname((String) map.get("CNAME"));
                mysf.setCtel((String) map.get("CTEL"));
                mysf.setMdate((String) map.get("MDATE"));
                mysf.setEid(Long.valueOf(map.get("EID").toString()));
                mysf.setMyzj((Float) map.get("MYZJ"));
                mysf.setMbegintime((String) map.get("MBEGintIME"));
                mysfList.add(mysf);
            }
        }
        return mysfList;
    }
}
