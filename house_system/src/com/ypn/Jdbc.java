package com.ypn;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @author ypn
 * @date 2020/8/8
 * @motto I raise pigs in your field
 * @desc
 */
public class Jdbc {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getconn() {
        try {
            InputStream in = Jdbc.class.getClassLoader().getResourceAsStream("sql.properties");
            //使用Properties类
            Properties properties = new Properties();
            properties.load(in);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String pwd = properties.getProperty("password");
            //通过反射加载驱动类
            Class.forName(driver);
            //获得连接
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void closeConn(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 添加、修改、删除的方法
     *
     * @param sql
     * @param args
     */
    //添加、删除、改的方法
    public static void add(String sql, Object... args) {
        try {
            //获取连接
            connection = Jdbc.getconn();
            //创建语句
            statement = connection.prepareStatement(sql);
            //设置SQL语句的参数，setXXX方法第一个参数是占位符位置，从1开始，第二个参数是传入SQL语句的数据
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
            //获得结果集
            statement.execute();
            System.out.println("完成");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接，释放资源
            Jdbc.closeConn(resultSet, statement, connection);
        }
    }

    /**
     * 查询
     *
     * @param sql
     * @param args
     * @return
     */
    public static List<Map<String, Object>> query(String sql, Object... args) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            //获取连接
            connection = Jdbc.getconn();
            //创建语句
            statement = connection.prepareStatement(sql);
            //设置SQL语句的参数，setXXX方法第一个参数是占位符位置，从1开始，第二个参数是传入SQL语句的数据
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
            }
            //获得结果集
            resultSet = statement.executeQuery();
            //获得列数
            int i = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {//只要resultSet中还有东西，就会一直执行
                Map<String, Object> map = new HashMap<String, Object>();
                for (int j = 0; j < i; j++) {
                    //resultSet.getMetaData().getColumnName(j+1),为获得当前数据的列名
                    map.put(resultSet.getMetaData().getColumnName(j + 1), resultSet.getObject(j + 1));
                }
                //把读取到的数据以map的形式添加到list
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Jdbc.closeConn(resultSet, statement, connection);
        }
        return list;
    }

    /**
     * 使用反射实现通用查询
     * @param sql
     * @param cls
     * @param objects
     * @param <E>
     * @return
     */
    public static <E> List<E> query2(String sql, Class<E> cls, Object...objects) {
        connection = Jdbc.getconn();
        E entity = null;
        List<E> list = new ArrayList<E>();
        try {
            statement = connection.prepareStatement(sql);
            if(objects != null && objects.length > 0) {
                for(int i = 0; i < objects.length; i++) {
                    statement.setObject(i+1, objects[i]);
                }
            }
            resultSet = statement.executeQuery();
            ResultSetMetaData rsm = resultSet.getMetaData();
            int columnCount = rsm.getColumnCount();
            while(resultSet.next()) {
                entity = cls.newInstance();
                for(int i = 0; i < columnCount; i++) {
                    String columnName = rsm.getColumnName(i+1);
                    Object columnValue = resultSet.getObject(columnName);
                    //通过字段名获取属性，try{名称不匹配}catch{到配置文件查找对应名称}
                    Field field = null;
                    try{
                        field = cls.getDeclaredField(columnName);
                    }catch (Exception e){
                        throw new RuntimeException("The column name does not match the field name");
                    }
                    field.setAccessible(true);
                    field.set(entity, columnValue);
                }
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc.closeConn(resultSet,statement,connection);
        }
        return list;
    }
}
