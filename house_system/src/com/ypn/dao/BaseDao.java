package com.ypn.dao;

import com.ypn.until.SystemStringUtils;
import com.ypn.until.JdbcUntils;
import org.apache.commons.beanutils.BeanUtils;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/8
 * @motto I raise pigs in your field
 * @desc
 */
public abstract class BaseDao<T> {
    /**
     * 快速查询（当实体类存在大写（查询sql也没写别名）的时候不可用）
     * @param sql
     * @param objects
     * @param map
     * @param clazz
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public final List<T> query(String sql, Object[] objects, Map<String, Object> map, Class<T> clazz) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        //获取连接
        connection = JdbcUntils.getConn();
        Integer start = (Integer) map.get("start");
        Integer PageSize = (Integer) map.get("PageSize");
        if (map != null && start != null && PageSize != null) {
            sql += " limit " + start + "," + PageSize;
        }
        ps = connection.prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, i);
            }
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            T bean = clazz.newInstance();
            getToBean(rs, bean);
            list.add(bean);
        }
        JdbcUntils.close(rs, ps, connection);
        return list;
    }

    /**
     *
     * @param rs
     * @param bean
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    protected void getToBean(ResultSet rs, Object bean) throws SQLException, InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        int count = rs.getMetaData().getColumnCount();
        for (int i = 0; i < count; i++) {
            //列名
            String name = rs.getMetaData().getColumnName(i + 1);
            //数据
            Object value = rs.getObject(i + 1);
            //因为数据库的列名是大写  全部转小写 由于我的实体类属性是大写  所以这里不转
            name=SystemStringUtils.bigToSmall(name);
            map.put(name, value);
//            System.out.println("map:"+map);
        }
        //这个方法会遍历map<key,value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。
        BeanUtils.populate(bean, map);
    }

    public final List<T> query1(String sql, Object[] objects, Class clazz) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        //获取连接
        connection = JdbcUntils.getConn();
        ps = connection.prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
                System.out.println(objects[i]);
            }
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            T bean = (T) clazz.newInstance();
            getToBean(rs, bean);
            list.add(bean);
        }
        JdbcUntils.close(rs, ps, connection);
        return list;
    }


    //    public final List<T> QueryRecords(String sql, Object[] objects, Map<String, Object>, Class<T> tClass) {
//        List<T> list = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement sta = null;
//        ResultSet rs = null;
//        try {
//            //获取连接
//            conn = JdbcUntils.getConn();
//            //执行sql
//            sta = conn.prepareStatement(sql);
//            for (int i=0;i<objects.length;i++){
//                sta.setObject(i+1,objects[i]);
//            }
//            //获得结果集
//            rs=sta.executeQuery();
//            while (rs.next()){
//                try {
//                    T bean = tClass.newInstance();
//                    list.add(bean);
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            JdbcUntils.close(rs,sta, conn);
//        }
//        return list;
//    }
    public List<Map<String, Object>> queryAll(String sql) {
        List<Map<String, Object>> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //获取连接
        connection = JdbcUntils.getConn();
        //创建语句
        try {
            if (SystemStringUtils.isString(sql)) {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                //结果的行数
                int i = resultSet.getMetaData().getColumnCount();
                while (resultSet.next()) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    for (int j = 0; j < i; j++) {
                        map.put(resultSet.getMetaData().getColumnName(j + 1), resultSet.getObject(j + 1));
                    }
                    list.add(map);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
