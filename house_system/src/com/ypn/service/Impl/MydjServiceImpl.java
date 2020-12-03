package com.ypn.service.Impl;

import com.ypn.dao.impl.MycusDaoImpl;
import com.ypn.dao.impl.MydjDaoImpl;
import com.ypn.entity.MyHouse;
import com.ypn.entity.Mycus;
import com.ypn.entity.Mydj;
import com.ypn.until.JdbcUntils;

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
 * @date 2020/8/22
 * @motto I raise pigs in your field
 * @desc 登记入住业务层
 */
public class MydjServiceImpl {
    MydjDaoImpl mydjDao = new MydjDaoImpl();

    /**
     * 查询
     *
     * @param objects
     * @return
     */
    public final List<Map<String, Object>> queryRecords(Object[] objects) {

        return mydjDao.queryRecords(mydjDao.getSelect(), objects);
    }

    /**
     * 获取列的总数
     */
    public Integer queryCount() {

        return mydjDao.queryCount(mydjDao.getSqlCount(), null);

    }

    public Boolean add(Mydj mydj) {
        Object[] objects = {mydj.getCid(), mydj.getHid(), mydj.getMyj(), mydj.getMyzj(), mydj.getMbegintime()};
        return mydjDao.add(mydjDao.getAddSql(), objects);
    }

    /**
     * List<map>封装为存放到实体类的集合(分页)
     */
    public List<Mydj> queryLimit(Map<String, Object> pageMap, Object[] objects) {
        List<Map<String, Object>> list = mydjDao.queryRecords(mydjDao.getSelect(), pageMap, objects);
        List<Mydj> mydjList = new ArrayList<Mydj>();
        //当查询有结果的时候
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Mydj mydj = new Mydj();
                //获取当前下标的数据
                Map<String, Object> map = list.get(i);
                mydj.setMid(Long.valueOf(map.get("MID").toString()));
                ;
                mydj.setMdate((String) map.get("MDATE"));
                mydj.setEid(Long.valueOf(map.get("EID").toString()));
                mydj.setCid(Long.valueOf(map.get("CID").toString()));
                mydj.setHid(Long.valueOf(map.get("HID").toString()));
                mydj.setMimg((String) map.get("MIMG"));
                mydj.setMyj((Float) map.get("MYJ"));
                mydj.setMyzj((Float) map.get("MYZJ"));
                mydj.setMflag(Long.valueOf(map.get("MFLAG").toString()));
                mydj.setMbegintime((String) map.get("MBEGintIME"));
                mydj.setEname((String) map.get("ENAME"));
                mydj.setCtel((String) map.get("CTEL"));
                mydj.setHaddress((String) map.get("HADDRESS"));
                mydj.setHfh((String) map.get("HFH"));
                mydj.setCname((String) map.get("CNAME"));
                mydjList.add(mydj);
            }
        }
        return mydjList;
    }

    public List<MyHouse> screen(Object[] objects, Map<String, Object> map) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException {
        List<MyHouse> list = new ArrayList<>();
//        String sql = "select myhouse.HID hid,SNAME sname,ANAME aname,HADDRESS hAddress,HFH hfh,HHX hhx,HMJ hmj,HCX hcx ,HMONEY hMoney,HFLAG hFlag from myhouse,myarea,mysort WHERE myhouse.SID=mysort.SID AND myarea.AID=myhouse.AID ";
        String sql = "select myhouse.HID,HADDRESS,HFH,CNAME,CTEL,ENAME,MDATE,MYJ,MYZJ,MFLAG\n" +
                "from mydj,myhouse,myarea,mysort,mycus,myemp WHERE myhouse.SID=mysort.SID AND myarea.AID=myhouse.AID AND mydj.HID=myhouse.HID AND mycus.CID=mydj.CID AND myemp.EID=mydj.EID";
//        String countSql="select count(*) count from myhouse,myarea,mysort WHERE myhouse.SID=mysort.SID AND myarea.AID=myhouse.AID";
        StringBuffer sb = new StringBuffer(sql);
//        StringBuffer sb1 =new StringBuffer(countSql);
        List list1 = new ArrayList();
        Integer hid = null;
        Integer aid = null;
        Integer sid = null;
        if (objects != null) {
             hid= (Integer) objects[0];
            aid = (Integer) objects[1];
            sid = (Integer) objects[2];
            if (objects.length > 0 && objects != null) {
                //当出租状态有条件
                if (!(hid.equals("-1"))) {
                    sb.append(" AND myhouse.HID=? ");
//                    sb1.append(" AND HFLAG="+flag);
                    list1.add("flag,"+hid);
                }
                //当房屋类型有条件
                if (aid != 0) {
                    sb.append(" AND myhouse.AID=? ");
//                    sb1.append(" AND myhouse.AID="+aid);
                    list1.add("aid,"+aid);
                }
                //当出租房屋区域有条件
                if (sid != 0) {
                    sb.append(" AND myhouse.SID =? ");
//                    sb1.append(" AND myhouse.SID ="+sid);
                    list1.add("sid,"+sid);
                }
            }
        }
//       int count= myHouseDao.queryCount(sb1.toString(),null);
        System.out.println(sb.toString());
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
//        myhouse.HID,HADDRESS,HFH,CNAME,CTEL,ENAME,MDATE,MYJ,MYZJ,MFLAG
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
//            myHouse.setAllCount(count);
            list.add(myHouse);
        }
        JdbcUntils.close(rs, sta, conn);
        return list;
    }
}
