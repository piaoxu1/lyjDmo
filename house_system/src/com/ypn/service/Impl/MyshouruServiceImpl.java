package com.ypn.service.Impl;

import com.ypn.dao.impl.MysfDaoImpl;
import com.ypn.dao.impl.MyshouruDao;
import com.ypn.entity.Mysf;
import com.ypn.entity.Myshouru;
import com.ypn.service.ServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
public class MyshouruServiceImpl implements ServiceDao {
    MyshouruDao myshouruDao = new MyshouruDao();

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return myshouruDao.queryRecords(myshouruDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return myshouruDao.queryCount(myshouruDao.getSqlCount(), null);

    }

    public List<Myshouru> query(Object[] objects, Map<String, Object> map) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException {
        return myshouruDao.query(myshouruDao.getSelect1(), objects, map, Myshouru.class);
    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Myshouru> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = myshouruDao.queryRecords(myshouruDao.getSelect(), pageMap, objects);
        List<Myshouru> myshourus = new ArrayList<Myshouru>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Myshouru myshouru = new Myshouru();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                myshouru.setSid(Long.valueOf(map.get("SID").toString()));
                myshouru.setEid(Long.valueOf(map.get("EID").toString()));
                myshouru.setErealname((String) map.get("EREALNAME"));
                myshouru.setSmoney((Float) map.get("SMONEY"));
                myshouru.setStm((String) map.get("STM"));
                myshouru.setStime((String) map.get("STIME"));
                myshouru.setSremark((String) map.get("SREMARK"));
                myshourus.add(myshouru);
            }
        }
        return myshourus;
    }

    public boolean add(Myshouru myshouru) {
        Object[] objects = {myshouru.getSmoney(), myshouru.getStm(), myshouru.getSremark()};
        return myshouruDao.add(myshouruDao.getAddSql(), objects);
    }
}
