package com.ypn.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import com.ypn.entity.Mycus;
import com.ypn.entity.Mydj;
import com.ypn.service.Impl.MydjServiceImpl;
import com.ypn.until.JacksonUntil;
import com.ypn.until.NumberUntil;
import com.ypn.until.PagesUntil;
import netscape.javascript.JSUtil;

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
 * @date 2020/8/22
 * @motto I raise pigs in your field
 * @desc  登记入住控制层
 */
@WebServlet("/mydj")
public class MydjController extends SystemBaseController {
    MydjServiceImpl mydjService = new MydjServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        String type = req.getParameter("type");
        if (type.equals("add")) {
            String time = req.getParameter("dj.mbegintime");
            String cid = req.getParameter("dj.cid");
            String hid = req.getParameter("dj.hid");
            String myj = req.getParameter("dj.myj");
            String myzj = req.getParameter("dj.myzj");
            Mydj mydj = new Mydj();
            mydj.setCid(Long.parseLong(cid));
            mydj.setHid(Long.parseLong(hid));
            mydj.setMyj(Float.parseFloat(myj));
            mydj.setMyzj(Float.parseFloat(myzj));
            mydj.setMbegintime(time);
            Boolean sta = mydjService.add(mydj);
            System.out.println(mydj.toString());
            System.out.println(sta);
            succss(resp, sta);
        }
        if (type.equals("findall")) {
            resultList = new ArrayList<>();
            Map<String, Object> map = PagesUntil.getPageParams(req);
            String str1Josn = null;
            //获得count(*)、总页数
            int countNum = mydjService.queryCount();
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"), 1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<Mydj> myHouseList = mydjService.queryLimit(map, null);
            for (int i = 0; i < myHouseList.size(); i++) {
                Mydj mydj = myHouseList.get(i);
                mydj.setAllCount(countNum);
                mydj.setAllPage(countPage);
                mydj.setNext(nextIndex);
                mydj.setUp(upIndex);
                mydj.setCurrent(current);
                resultList.add(mydj);
            }
            responseResult(resp, str1Josn);
            System.out.println("传入前端的json数据是：" + JacksonUntil.obj2Json(resultList).toString());
        }
    }
}
