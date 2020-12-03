package com.ypn.controller;

import com.ypn.entity.Myht;
import com.ypn.entity.Myzhichu;
import com.ypn.service.Impl.MyhtServiceImpl;
import com.ypn.service.Impl.MyzhichuServiceImpl;
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
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc
 */
@WebServlet("/myht")
public class MyhtController extends SystemBaseController{
    MyhtServiceImpl myhtService = new MyhtServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        String str= req.getParameter("type");
        if (str.equals("add")){
            String name = req.getParameter("hthtname");
            Object[] o ={name};
            boolean type = myhtService.add(o);
            succss(resp,type);
        }
        if (str.equals("findall")){
            resultList = new ArrayList<>();
            Map<String, Object> map = PagesUntil.getPageParams(req);
            String str1Josn = null;
            //获得count(*)、总页数
            int countNum = myhtService.queryCount();
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"), 1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<Myht> myHouseList = myhtService.queryLimit(map, null);
            for (int i = 0; i < myHouseList.size(); i++) {
                Myht myht = myHouseList.get(i);
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
