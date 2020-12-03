package com.ypn.service.Impl;

import com.ypn.controller.Constants;
import com.ypn.dao.impl.MyHouseDaoImpl;
import com.ypn.entity.MyHouse;
import com.ypn.service.ServiceDao;
import com.ypn.until.JdbcUntils;
import com.ypn.until.NumberUntil;
import com.ypn.until.Pages;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/19
 * @motto I raise pigs in your field
 * @desc
 */
public class MyHouseServiceImpl1 implements ServiceDao {
    MyHouseDaoImpl myHouseDao = new MyHouseDaoImpl();

    /**
     * 添加
     */
//    SID,AID,HADDRESS,HFH,HHX,HMJ,HCX,HMONEY,HWF,HDX,HSF,HMQ,DKD,SKD,MKD,HJP,HREMARK,HIMG,HFLAG
    public boolean add(MyHouse myHouse) {
        Object[] o = new Object[17];
        o[0] = myHouse.getSid();
        o[1] = myHouse.getAid();
        o[2] = myHouse.gethAddress();
        o[3] = myHouse.getHfh();
        o[4] = myHouse.getHhx();
        o[5] = myHouse.getHmj();
        o[6] = myHouse.getHcx();
        o[7] = myHouse.gethMoney();
        o[8] = myHouse.getHwf();
        o[9] = myHouse.getHdx();
        o[10] = myHouse.getHsf();
        o[11] = myHouse.getHmq();
        o[12] = myHouse.getDkd();
        o[13] = myHouse.getSkd();
        o[14] = myHouse.getMkd();
        o[15] = myHouse.getHjp();
        o[16] = myHouse.gethRemark();
        return myHouseDao.add(myHouseDao.getSqlAdd(), o);
    }

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return myHouseDao.queryRecords(myHouseDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return myHouseDao.queryCount(myHouseDao.getSqlCount(), null);

    }


    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<MyHouse> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = myHouseDao.queryRecords(myHouseDao.getSelect(), pageMap, objects);
        List<MyHouse> myHouses = new ArrayList<MyHouse>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                MyHouse house = new MyHouse();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                house.setHid(Long.valueOf(map.get("HID").toString()));
                house.setSid(Long.valueOf(map.get("SID").toString()));
                house.setAid(Long.valueOf(map.get("AID").toString()));
                house.setsName((String) map.get("SNAME"));
                house.setaName((String) map.get("ANAME"));
                house.sethAddress((String) map.get("HADDRESS"));
                house.setHfh((String) map.get("HFH"));
                house.setHhx((String) map.get("HHX"));
                house.setHmj((String) map.get("HMJ"));
                house.setHcx((String) map.get("HCX"));
                house.sethMoney((Float) map.get("HMONEY"));
                house.setHwf((Float) map.get("HWF"));
                house.setHdx((Float) map.get("HDX"));
                house.setHsf((Float) map.get("HSF"));
                house.setHmq((Float) map.get("HMQ"));
                house.setDkd((Float) map.get("DKD"));
                house.setSkd((Float) map.get("SKD"));
                house.setMkd((Float) map.get("MKD"));
                house.setHjp((String) map.get("HJP"));
                house.sethRemark((String) map.get("HREMARK"));
                house.sethImg((String) map.get("HIMG"));
                house.sethFlag((String) map.get("HFLAG"));
                myHouses.add(house);
            }
        }
        return myHouses;
    }


    /**
     * 筛选查询
     *
     * @param objects
     * @param map
     * @return
     * @throws InvocationTargetException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public List<MyHouse> screen(Object[] objects, Map<String, Object> map) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException {
        List<MyHouse> list = new ArrayList<>();
        String sql = "select  myhouse.HID hid,SNAME sName,ANAME aName,HADDRESS hAddress,HFH hfh,HHX hhx,HMJ hmj,HCX hcx ,HMONEY hMoney,HFLAG hflag from myhouse,myarea,mysort WHERE myhouse.SID=mysort.SID AND myarea.AID=myhouse.AID ";
        String countSql = "select count(*) count from myhouse,myarea,mysort WHERE myhouse.SID=mysort.SID AND myarea.AID=myhouse.AID";
        StringBuffer sb = new StringBuffer(sql);
        StringBuffer sb1 = new StringBuffer(countSql);
        List list1 = new ArrayList();
        String flag = null;
        Integer aid = null;
        Integer sid = null;
        if (objects != null) {
            flag = (String) objects[0];
            aid = (Integer) objects[1];
            sid = (Integer) objects[2];
            if (objects.length > 0 && objects != null) {
                //当出租状态有条件
                if (!(flag.equals("-1"))) {
                    sb.append(" AND HFLAG=? ");
                    sb1.append(" AND HFLAG=" + flag);
                    list1.add("flag," + flag);
                }
                //当房屋类型有条件
                if (aid != 0) {
                    sb.append(" AND myhouse.AID=? ");
                    sb1.append(" AND myhouse.AID=" + aid);
                    list1.add("aid," + aid);
                }
                //当出租房屋区域有条件
                if (sid != 0) {
                    sb.append(" AND myhouse.SID =? ");
                    sb1.append(" AND myhouse.SID =" + sid);
                    list1.add("sid," + sid);
                }
            }
        }
        int count = myHouseDao.queryCount(sb1.toString(), null);
        System.out.println(sb1.toString());
        //分页参数
        int current = NumberUntil.getIntegerValue(map.get("current"), 1);
        Pages pages = new Pages();
        int countPage = pages.getAllPages(count, Constants.PAGE_SIZE_DEFAULT);
        //上一页
        int upIndex = pages.getUp(current);
        //下一页
        int nextIndex = pages.getNext(current, countPage);

//获取分页参数
        if (map.size() != 0) {
            Object start = map.get("start");
            Object PageSize = map.get("PageSize");
            if (start != null && PageSize != null) {
                sb.append(" limit " + start + "," + PageSize);
            }
        }
        System.out.println(sb);
        Connection conn = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        conn = JdbcUntils.getConn();
        sta = conn.prepareStatement(sb.toString());

        //给对应的占位符赋值
        if (list1.size() > 0 && list1 != null) {
            for (int i = 0; i < list1.size(); i++) {
                String str = (String) list1.get(i);
                String[] strings = str.split(",");
                sta.setObject(i + 1, strings[1]);
                System.out.println(map.get(i));
            }
        }
        rs = sta.executeQuery();
        while (rs.next()) {
            MyHouse myHouse = new MyHouse();
            myHouse.setHid(rs.getLong("hid"));
            myHouse.setsName(rs.getString("sName"));
            myHouse.setaName(rs.getString("aName"));
            myHouse.sethAddress(rs.getString("hAddress"));
            myHouse.setHhx(rs.getString("hhx"));
            myHouse.setHmj(rs.getString("hmj"));
            myHouse.setHfh(rs.getString("hfh"));
            myHouse.setHcx(rs.getString("hcx"));
            myHouse.sethMoney(rs.getFloat("hmoney"));
            myHouse.sethFlag(rs.getString("hflag"));
            myHouse.setAllCount(count);
            myHouse.setAllPage(countPage);
            myHouse.setNext(nextIndex);
            myHouse.setCurrent(current);
            myHouse.setUp(upIndex);
            list.add(myHouse);
        }
        JdbcUntils.close(rs, sta, conn);
        return list;
    }


}
