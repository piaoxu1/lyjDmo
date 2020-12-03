package com.ypn.dao;

import com.ypn.until.JdbcUntils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/11
 * @motto I raise pigs in your field
 * @desc
 */
public abstract class SystemDao extends BaseDao {
    /**
     * 查询(不支持分页)
     *
     * @param sql
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(String sql, Object... objects) {
        return JdbcUntils.query(sql, objects);
    }

    /**
     * 通用查询(支持分页)
     *
     * @param sql
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(String sql, Map<String, Object> map, Object... objects) {
        return JdbcUntils.query(sql, map, objects);
    }

    /**
     * 添加
     * @param sql
     * @param objects
     * @return
     */
    public final Boolean add(String sql, Object[] objects) {
        return JdbcUntils.update(sql, objects);
    }


    /**
     * 获取列的总数
     *
     * @param sql
     * @param objects
     * @return
     * @throws SQLException
     */
    public final Integer queryCount(String sql, Object[] objects) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = 0;
        //获取连接
        conn = JdbcUntils.getConn();
        //预编译
        try {
            ps = conn.prepareStatement(sql);
            if (objects != null && objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i + 1, objects[i]);
                }
            }
            //获得结果
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
//            List<Map<String, Object>> l = new ArrayList<>();
//            int i = rs.getMetaData().getColumnCount();
//            while (rs.next()) {
//                Map<String, Object> map = new HashMap<String, Object>();
//                for (int j = 0; j < i; j++) {
//                    map.put(rs.getMetaData().getColumnName(j + 1), rs.getObject(j + 1));
//                }
//                l.add(map);
//            }
//            count = l.size();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUntils.close(rs, ps, conn);
        }
        return count;
    }
}
