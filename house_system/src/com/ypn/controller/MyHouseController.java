package com.ypn.controller;

import com.ypn.entity.MyHouse;
import com.ypn.entity.Sort;
import com.ypn.service.Impl.MyHouseServiceImpl;
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
 * @date 2020/8/19
 * @motto I raise pigs in your field
 * @desc 房屋资料控制层
 */
@WebServlet("/house")
public class MyHouseController extends SystemBaseController {
    MyHouseServiceImpl myHouseService = new MyHouseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type =req.getParameter("type");
        //房屋资料添加
        if (type.equals("add")){

            String sid=req.getParameter("sid");
            String aid=req.getParameter("aid");
            String haddress=req.getParameter("haddress");
            String hfh=req.getParameter("hfh");
            String hhx=req.getParameter("hhx");
            String hmj=req.getParameter("hmj");
            String hcx=req.getParameter("hcx");
            String hmoney=req.getParameter("hmoney");
            String hwf=req.getParameter("hwf");
            String hdx=req.getParameter("hdx");
            String hsf=req.getParameter("hsf");
            String hmq=req.getParameter("hmq");
            String dkd=req.getParameter("dkd");
            String skd=req.getParameter("skd");
            String mkd=req.getParameter("mkd");
            String hremark=req.getParameter("hremark");
            String hjp=req.getParameter("hjp");
            //            SID,AID,HADDRESS,HFH,HHX,HMJ,HCX,HMONEY,HWF,HDX,HSF,HMQ,DKD,SKD,MKD,HJP,HREMARK
            MyHouse myHouse = new MyHouse();
            myHouse.setSid(Long.valueOf(sid));
            myHouse.setAid(Long.valueOf(aid));
            myHouse.sethAddress(haddress);
            myHouse.setHfh(hfh);
            myHouse.setHhx(hhx);
            myHouse.setHmj(hmj);
            myHouse.sethMoney(Float.valueOf(hmoney));
            myHouse.setHwf(Float.valueOf(hwf));
            myHouse.setHdx(Float.valueOf(hdx));
            myHouse.setHsf(Float.valueOf(hsf));
            myHouse.setHmq(Float.valueOf(hmq));
            myHouse.setDkd(Float.valueOf(dkd));
            myHouse.setSkd(Float.valueOf(skd));
            myHouse.setMkd(Float.valueOf(mkd));
            myHouse.setHcx(hcx);
            myHouse.setHjp(hjp);
            myHouse.sethRemark(hremark);
           Boolean b =  myHouseService.add(myHouse);
           succss(resp,b);
        }
        if (type.equals("findall")){
            Map<String,Object> map = currentArgs(req);
            String strJosn = null;
            //获得count(*)、总页数
            int countNum = myHouseService.queryCount();
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"),1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<MyHouse> myHouseList = myHouseService.queryLimit(map,null);
            for (int i = 0; i < myHouseList.size(); i++) {
                MyHouse myHouse = myHouseList.get(i);
                myHouse.setAllCount(countNum);
                myHouse.setAllPage(countPage);
                myHouse.setNext(nextIndex);
                myHouse.setUp(upIndex);
                myHouse.setCurrent(current);
                resultList.add(myHouse);
            }
            responseResult(resp,strJosn);
        }

    }
}
