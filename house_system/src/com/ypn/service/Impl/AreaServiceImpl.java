package com.ypn.service.Impl;

import com.ypn.dao.impl.AreaDaoImpl;
import com.ypn.entity.Area;
import com.ypn.entity.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/16
 * @motto I raise pigs in your field
 * @desc
 */
public class AreaServiceImpl {
    AreaDaoImpl areaDao = new AreaDaoImpl();
    //查询所有
    private String sqlLimit = "select * from myarea ";
    private String select = "select * from myarea";
    private String countSql = "select count(*) from myarea";
    private String addSql = "INSERT myarea(ANAME) VALUES(?)";

    public final boolean add(Object[] objects) {
        return areaDao.add(addSql, objects);
    }

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return areaDao.queryRecords(select, objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount(Object[] objects) {
        Integer count = 0;

        count = areaDao.queryCount(countSql, objects);
        return count;
    }

    /**
     * List<map> 将对象封装为实体类集合 无分页
     */
    public List<Area> queryListTodto(Object[] objects) {
        //查询所有
        List<Map<String, Object>> list = queryRecords(objects);
        List<Area> areas = new ArrayList<Area>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Area area = new Area();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                area.setAID(Long.valueOf(map.get("AID").toString()));
                area.setANAME((String) map.get("ANAME"));
                //添加到当前Dept对象List<Dept>中
                areas.add(area);
            }
        }
        return areas;
    }

    /**
     * List<map> 将对象封装为实体类集合 分页
     */
    public List<Area> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = areaDao.queryRecords(sqlLimit, pageMap, objects);
        List<Area> areas = new ArrayList<Area>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Area area = new Area();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                area.setAID(Long.valueOf(map.get("AID").toString()));
                area.setANAME((String) map.get("ANAME"));
                //添加到当前Dept对象List<Dept>中
                areas.add(area);
            }
        }
        return areas;
    }

}
