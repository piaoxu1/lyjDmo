package com.ypn.controller;

import com.ypn.entity.Myht;
import com.ypn.entity.Myzc;
import com.ypn.service.Impl.MyhtServiceImpl;
import com.ypn.service.Impl.MyzcServiceImpl;
import com.ypn.until.JacksonUntil;
import com.ypn.until.NumberUntil;
import com.ypn.until.PagesUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/28
 * @motto I raise pigs in your field
 * @desc  房屋政策控制类
 */
@WebServlet("/myzc")
public class MyzcController  extends  SystemBaseController{
    MyzcServiceImpl service = new MyzcServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        String str= req.getParameter("type");
        if (str.equals("add")){
            String title = req.getParameter("zc.ctitle");
            String remark = req.getParameter("content");
            Myzc myzc = new Myzc();
            myzc.setCtitle(title);
            myzc.setCremark(remark);
            boolean type = service.add(myzc);
            if (type==true){
                resp.sendRedirect("http://localhost:8088/web_example_war_exploded/zc/all.html");
            }else {
//                resp.sendRedirect("http://localhost:8088/web_example_war_exploded/");
            }
        }
        if (str.equals("findall")){
            resultList = new ArrayList<>();
            Map<String, Object> map = PagesUntil.getPageParams(req);
            String str1Josn = null;
            //获得count(*)、总页数
            int countNum = service.queryCount();
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"), 1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<Myzc> myHouseList = null;
            try {
                myHouseList = service.queryLimit(map);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < myHouseList.size(); i++) {
                Myzc myht = myHouseList.get(i);
                myht.setAllCount(countNum);
                myht.setAllPage(countPage);
                myht.setNext(nextIndex);
                myht.setUp(upIndex);
                myht.setCurrent(current);
                resultList.add(myht);
            }
            responseResult(resp, str1Josn);
            System.out.println("传入前端的json数据是：" + JacksonUntil.obj2Json(resultList));
        }

    }
}
