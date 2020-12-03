package com.ypn.test;

import com.ypn.Jdbc;
import com.ypn.entity.Dept;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * @author ypn
 * @date 2020/8/11
 * @motto I raise pigs in your field
 * @desc
 */
public class TestLoadProperties {
    static Connection conn;
    static PreparedStatement sta;
    static ResultSet rs;

    public static void main(String[] args) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("sql.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            System.out.println(driver + "\n" + url + "\n" + user + "\n" + password);
            //加载驱动
            Class.forName(driver);
            //获取连接
            Connection connection = DriverManager.getConnection(url, user, password);
            //预编译
            PreparedStatement statement = connection.prepareStatement("select * from mydept");
            List<Dept> list = new ArrayList<Dept>();
            //获得结果集
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Dept dept = new Dept();
                dept.setPID(resultSet.getLong(1));
                dept.setPNAME(resultSet.getString(2));
                dept.setPFLAG(resultSet.getLong(3));
                dept.setPREMARK(resultSet.getString(4));
                list.add(dept);
            }
            System.out.println(list.toString());
            //测试通用查询
            String sql = "select * from mydept where PID =?";
            List l = getAll(sql,2);
            System.out.println(l.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     *
     * @param conn
     * @param ps
     * @param rs
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static List<Map<String, Object>> getAll(String sql, Object... args) {
        List<Map<String, Object>> list = new ArrayList<>();
        //获取连接
        conn = Jdbc.getconn();
        try {
            //预编译
            sta = conn.prepareStatement(sql);
            // 当不传入参数不进入  设置SQL语句的参数，setXXX方法第一个参数是占位符位置，从1开始，第二个参数是传入SQL语句的数据
            if (args.length > 0 && args != null) {
                for (int i = 0; i < args.length; i++) {
                    sta.setObject(i + 1, args[i]);
                }
            }
            //获得结果集
            rs = sta.executeQuery();
            //获取列数
            int i = rs.getMetaData().getColumnCount();
            while (rs.next()) {//只要resultSet中还有东西，就会一直执行
                Map<String, Object> map = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    //rs.getMetaData().getColumnName(j+1)获取对应字段名  rs.getObject获取对应字段的值
                    map.put(rs.getMetaData().getColumnName(j + 1), rs.getObject(j + 1));
                }
                //把添加到map的数据存入list
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接 释放资源
            Jdbc.closeConn(rs, sta, conn);
        }
        return list;
    }
}
