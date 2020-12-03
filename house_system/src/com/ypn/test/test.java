package com.ypn.test;

import com.ypn.dao.impl.MyHouseDaoImpl;
import com.ypn.dao.impl.MycusDaoImpl;
import com.ypn.entity.Dept;
import com.ypn.entity.MyHouse;
import com.ypn.service.Impl.MyHouseServiceImpl;
import com.ypn.until.JdbcUntils;
import com.ypn.until.SystemStringUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/6
 * @motto I raise pigs in your field
 * @desc 九九乘法表
 */
public class test {
//    private Decimal xx;
    public static void main(String[] args) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException {
        MyHouseServiceImpl service = new MyHouseServiceImpl();
        MyHouseDaoImpl dao = new MyHouseDaoImpl();
        Object[] objects = {"-1",1,0};
        Map<String,Object> map = new HashMap<>();
//        map.put("current",1);
        map.put("start",0);
        map.put("PageSize",5);
//        List<MyHouse> list1 = service.screen(null, map);
        List<MyHouse> list = service.screen(objects, map);
//        System.out.println(list1.toString());
        System.out.println(list.toString());
//        String sql = "select myhouse.HID hid,SNAME sname,ANAME aname,HADDRESS haddress,HFH hfh,HHX hhx,HMJ hmj,HCX hcx ,HMONEY hmoney,HFLAG hflag from myhouse,myarea,mysort WHERE myhouse.SID=mysort.SID AND myarea.AID=myhouse.AID ";
//        List<MyHouse> list = dao.query1("select * from myhouse".toString(),null,MyHouse.class);
//        System.out.println(list.toString());
    }
}