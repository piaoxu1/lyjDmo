package com.ypn.test;

import com.ypn.until.JdbcUntils;

import java.util.List;

/**
 * @author ypn
 * @date 2020/8/6
 * @motto I raise pigs in your field
 * @desc
 */
public class testJDBC {
    public static void main(String[] args) {
//        //测试添加
//        String sql ="INSERT INTO test(id,name) VALUES(?,?)";
//        JdbcUntils.add(sql,2,"tmx");
//        //测试删除
//        String sql1="delete from test where name=?";
//        JdbcUntils.add(sql1,"tmx");
//        //测试修改
//        String sql2="update test set id=?,name=? where name=?";
//        JdbcUntils.add(sql2,5,"clearlove","uzi");
//        //测试查找
//        String sql3="select * from test where id = ? ";
//        String sql4="select * from test  ";
//      List list= JdbcUntils.query(sql3,7);
//        List list1= JdbcUntils.query(sql4);
//        for (Object l:
//                list1) {
//            System.out.println(l.toString());
//        }
        String str = "123456";
        System.out.println(str.substring(0,2));
//        for (Object l:
//                list1) {
//            System.out.print(l+"\t");
//        }
    }
}
