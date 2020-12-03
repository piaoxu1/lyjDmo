package com.ypn.controller;

import com.ypn.entity.Mybiao;
import com.ypn.entity.Mybs;
import com.ypn.service.Impl.MybiaoServiceImpl;
import com.ypn.service.Impl.MybsServiceImpl;
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
@WebServlet("/mybs")
public class MybsController extends SystemBaseController {
    MybsServiceImpl mybiaoService = new MybsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        String type = req.getParameter("type");
        if (type.equals("findall")) {
            resultList = new ArrayList<>();
            Map<String, Object> map = PagesUntil.getPageParams(req);
            String str1Josn = null;
            //获得count(*)、总页数
            int countNum = mybiaoService.queryCount();
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"), 1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<Mybs> myHouseList = mybiaoService.queryLimit(map, null);
            for (int i = 0; i < myHouseList.size(); i++) {
                Mybs mybs = myHouseList.get(i);
                mybs.setAllCount(countNum);
                mybs.setAllPage(countPage);
                mybs.setNext(nextIndex);
                mybs.setUp(upIndex);
                mybs.setCurrent(current);
                resultList.add(mybs);
            }
            responseResult(resp, str1Josn);
            //通过response对象将json格式的数据返回给前端的方法
            System.out.println("传入前端的json数据是：" + JacksonUntil.obj2Json(resultList).toString());
        }
        if (type.equals("add")) {
            String hid = req.getParameter("bs.hid");
            String remark = req.getParameter("bs.bremark");
            Object[] objects = {hid, remark};
            boolean b = mybiaoService.add(objects);
            succss(resp, b);
        }
    }
}
