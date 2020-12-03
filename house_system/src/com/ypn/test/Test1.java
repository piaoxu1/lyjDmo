package com.ypn.test;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import com.ypn.dao.impl.DeptDaoImpl;
import com.ypn.entity.Dept;
import com.ypn.entity.Emp;
import com.ypn.entity.Mycus;
import com.ypn.service.Impl.DeptServiceImpl;
import com.ypn.service.Impl.EmpServiceImpl;
import com.ypn.service.Impl.MycuServiceImpl;
import com.ypn.until.SystemStringUtils;
import netscape.javascript.JSUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/8
 * @motto I raise pigs in your field
 * @desc 测试jdbc
 */
public class Test1 {

    public static void main(String[] args) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException {
        Field[] fields = Dept.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            int endIndex = fields[i].toString().length();
            //获取最后一个.后面的字符
            int start = fields[i].toString().lastIndexOf(".");
            //取实体类属性字段
            String end = fields[i].toString().substring(start + 1, endIndex);
            //实体类属性字段替换成小写
            String replace = fields[i].toString().replace(end, end.toLowerCase());
            System.out.println(fields[i].getName().toLowerCase());
            //原来的数据
            System.out.println("原来的数据:" + fields[i].toString());
            //理想变更后的数据
            System.out.println("理想的数据:" + replace);
            System.out.println(SystemStringUtils.nowDate());
            System.out.println(Long.decode("4"));
        }
    }


}


