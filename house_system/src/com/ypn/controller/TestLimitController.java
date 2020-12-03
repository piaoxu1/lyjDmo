package com.ypn.controller;

import com.ypn.entity.Dept;
import com.ypn.entity.MyHouse;
import com.ypn.entity.Sort;
import com.ypn.service.Impl.DeptServiceImpl;
import com.ypn.service.Impl.MyHouseServiceImpl;
import com.ypn.service.Impl.SortServiceImpl;
import com.ypn.until.JacksonUntil;
import com.ypn.until.NumberUntil;
import com.ypn.until.PagesUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/17
 * @motto I raise pigs in your field
 * @desc
 */
@WebServlet("/test")
public class TestLimitController extends  SystemBaseController{
    MyHouseServiceImpl myHouseService= new MyHouseServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        resultList = new ArrayList<>();
        String strJosn = null;
        Map<String,Object> map = PagesUntil.getPageParams(req);
        //获得count(*)、总页数
        int countNum = myHouseService.queryCount();
        int countPage = pages.getAllPages(countNum, myPages);
        current = NumberUntil.getIntegerValue(map.get("current"),1);
        //上一页
        int upIndex = pages.getUp(current);
        //下一页
        int nextIndex = pages.getNext(current, countPage);
        Object[] o  = new Object[]{};
        o[0]=  req.getParameter("sid");
        List<MyHouse> myHouseList = myHouseService.queryLimit(map,o);
        for (int i = 0; i < myHouseList.size(); i++) {
            MyHouse myHouse = myHouseList.get(i);
            MyHouse house = new MyHouse();
            house.setHid(myHouse.getHid());
            house.setSid(myHouse.getSid());
            house.setAid(myHouse.getAid());
            house.setsName(myHouse.getsName());
            house.setaName(myHouse.getaName());
            house.sethAddress(myHouse.gethAddress());
            house.setHfh(myHouse.getHfh());
            house.setHhx(myHouse.getHhx());
            house.setHmj(myHouse.getHmj());
            house.setHcx(myHouse.getHcx());
            house.sethMoney(myHouse.gethMoney());
            house.setHwf(myHouse.getHwf());
            house.setHdx(myHouse.getHdx());
            house.setHsf(myHouse.getHsf());
            house.setHmq(myHouse.getHmq());
            house.setDkd(myHouse.getDkd());
            house.setSkd(myHouse.getSkd());
            house.setMkd(myHouse.getMkd());
            house.setHjp(myHouse.getHjp());
            house.sethRemark(myHouse.gethRemark());
            house.sethImg(myHouse.gethImg());
            house.sethFlag(myHouse.gethFlag());
            house.setAllCount(countNum);
            house.setAllPage(countPage);
            house.setNext(nextIndex);
            house.setUp(upIndex);
            house.setCurrent(current);
            resultList.add(house);
        }
        resp.setContentType("application/json;charset=UTF-8");
        //json数据
        strJosn = JacksonUntil.obj2Json(resultList);
        String result = "strJosn" + strJosn;
        System.out.println(result);
        log(result);
        //通过response对象将json格式的数据返回给前端的方法
        resp.getWriter().write(strJosn);
    }
}
