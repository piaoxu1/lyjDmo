package com.ypn.controller;

import com.ypn.entity.Mycus;
import com.ypn.service.Impl.MycuServiceImpl;
import com.ypn.until.JacksonUntil;
import com.ypn.until.NumberUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/22
 * @motto I raise pigs in your field
 * @desc
 */
@WebServlet("/addcus")
public class MycusAddController extends SystemBaseController {
    MycuServiceImpl mycuService = new MycuServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        String str= req.getParameter("type");
        if(str.equals("add")){
            String name = req.getParameter("cus.cname");
            String sex = req.getParameter("cus.csex");
            String tel = req.getParameter("cus.ctel");
            String tel1 = req.getParameter("cus.ctel1");
            String card = req.getParameter("cus.ccard");
            Mycus mycus = new Mycus();
            mycus.setcName(name);
            mycus.setcSex(sex);
            mycus.setcTel(tel);
            mycus.setcTel1(tel1);
            mycus.setcCard(card);
            Boolean type=mycuService.addCustom(mycus);
            if (type == true) {
                resp.getWriter().write(JacksonUntil.obj2Json(1));
            } else {
                resp.getWriter().write(JacksonUntil.obj2Json(0));
            }
        }
        if(str.equals("findall")){
            Map<String,Object> map = currentArgs(req);
            String strJosn = null;
            //获得count(*)、总页数
            int countNum = mycuService.queryCount();
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"),1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<Mycus> myHouseList = mycuService.queryLimit(map,null);
            for (int i = 0; i < myHouseList.size(); i++) {
                Mycus mycus = myHouseList.get(i);
                Mycus mycus1 = new Mycus();
                mycus1.setcId(mycus.getcId());
                mycus1.setcName(mycus.getcName());
                mycus1.setcSex(mycus.getcSex());
                mycus1.setcTel(mycus.getcTel());
                mycus1.setcTel1(mycus.getcTel1());
                mycus1.setcCard(mycus.getcCard());
                mycus1.setAllCount(countNum);
                mycus1.setAllPage(countPage);
                mycus1.setNext(nextIndex);
                mycus1.setUp(upIndex);
                mycus1.setCurrent(current);
                resultList.add(mycus1);
            }
            responseResult(resp,strJosn);
        }




//        Mycus mycus = new Mycus();
//        mycus.setcId(9L);
//        mycus.setcName(name);
//        mycus.setcSex(sex);
//        mycus.setcTel(tel);
//        mycus.setcTel1(tel1);
//        mycus.setcCard(card);
//        Boolean type = mycuService.addCustom(mycus);
//        System.out.println(type);

    }
}
