package com.ypn.test;


import com.ypn.Jdbc;

import java.util.List;

/**
 * @author ypn
 * @date 2020/8/10
 * @motto I raise pigs in your field
 * @desc
 */
public class JdbcTest {
    public static void main(String[] args) {
//        //测试删除
//        String sql1="INSERT mydept VALUES (?,?,?,?)";
//        String sql2 = "delete from mydept where PID = ?";
//        Jdbc.add(sql2,6);
        //测试查找
        String sql = "select * from mydept";
        List list = Jdbc.query(sql);
        System.out.println(list.toString());
    }
}
