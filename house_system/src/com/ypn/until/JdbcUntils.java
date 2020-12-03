package com.ypn.until;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @author ypn
 * @date 2020/8/6
 * @motto I raise pigs in your field
 * @desc
 */
public class JdbcUntils {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static Connection getConn() {
        try {
            //使用load()方法读取输入流信息
//            properties.load(new FileInputStream("sql.properties"));
            InputStream in = JdbcUntils.class.getClassLoader().getResourceAsStream("sql.properties");
            //使用Properties类
            Properties properties = new Properties();
            properties.load(in);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String pwd = properties.getProperty("password");
            //加载驱动
            Class.forName(driver);
//            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(url, user, pwd);
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "root");

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
     * \
     * 关闭连接
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet, PreparedStatement statement, Connection connection) {
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
    public static Integer add(String sql, Object... args) {
        int type=0;
        try {
            //获取连接
            connection = JdbcUntils.getConn();
            //创建语句
            statement = connection.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
            }
           type= statement.executeUpdate();
            System.out.println("完成");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            JdbcUntils.close(resultSet, statement, connection);
        }
        return type;
    }
    public  static Boolean update(String sql, Object... args){
        if (JdbcUntils.add(sql,args)>0){
            return true;
        }else {
            return false;
        }

    }


    /**
     * 查询(不支持分页)
     *
     * @param sql
     * @param args
     * @return
     */
    public static List<Map<String, Object>> query(String sql, Object... args) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            //获取连接
            connection = JdbcUntils.getConn();
            //创建语句
            statement = connection.prepareStatement(sql);
            if (SystemStringUtils.isString(sql) && args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
            }
            resultSet = statement.executeQuery();
            int i = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int j = 0; j < i; j++) {
                    map.put(resultSet.getMetaData().getColumnName(j + 1), resultSet.getObject(j + 1));
                }
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUntils.close(resultSet, statement, connection);
        }
        return list;
    }

    /**
     * 查询(不支持分页)
     *
     * @param sql
     * @param args
     * @return
     */
    public static List<Map<String, Object>> query(String sql, Map<String, Object> pageMap, Object... args) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            //获取连接
            connection = JdbcUntils.getConn();
            //创建语句
            Object start = pageMap.get("start");
            Object PageSize = pageMap.get("PageSize");
            if (pageMap.size() != 0 && start != null && PageSize != null) {
                sql+=" limit "+start+","+PageSize;
                 statement=connection.prepareStatement(sql);
            }else {
                statement = connection.prepareStatement(sql);
            }
            if (SystemStringUtils.isString(sql) && args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
            }
            resultSet = statement.executeQuery();
            int i = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int j = 0; j < i; j++) {
                    map.put(resultSet.getMetaData().getColumnName(j + 1), resultSet.getObject(j + 1));
                }
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUntils.close(resultSet, statement, connection);
        }
        return list;
    }

//    /**
//     * 查询所有
//     *
//     * @param sql
//     * @param
//     * @return
//     */
//    public static List<Map<String, Object>> queryAll(String sql) {
//        List<Map<String, Object>> list = new ArrayList<>();
//        //获取连接
//        connection = JdbcUntils.getConn();
//        //创建语句
//        try {
//            if (SystemStringUtils.isString(sql)) {
//                statement = connection.prepareStatement(sql);
//                resultSet = statement.executeQuery();
//                //结果的行数
//                int i = resultSet.getMetaData().getColumnCount();
//                while (resultSet.next()) {
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    for (int j = 0; j < i; j++) {
//                        map.put(resultSet.getMetaData().getColumnName(j + 1), resultSet.getObject(j + 1));
//                    }
//                    list.add(map);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JdbcUntils.close(resultSet, statement, connection);
//        }
//        return list;
//    }


    public static <E> List<E> query2(String sql, Class<E> cls, Object... objects) {
        connection = getConn();
        E entity = null;
        List<E> list = new ArrayList<E>();
        try {
            statement = connection.prepareStatement(sql);
            if (objects != null && objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    statement.setObject(i + 1, objects[i]);
                }
            }
            resultSet = statement.executeQuery();
            ResultSetMetaData rsm = resultSet.getMetaData();
            int columnCount = rsm.getColumnCount();
            while (resultSet.next()) {
                entity = cls.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = rsm.getColumnName(i + 1);
                    Object columnValue = resultSet.getObject(columnName);
                    //通过字段名获取属性，try{名称不匹配}catch{到配置文件查找对应名称}
                    Field field = null;
                    try {
                        field = cls.getDeclaredField(columnName);
                    } catch (Exception e) {
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
            close(resultSet, statement, connection);
        }
        return list;
    }


}
