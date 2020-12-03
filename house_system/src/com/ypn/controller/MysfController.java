package com.ypn.controller;

import com.ypn.entity.Mydj;
import com.ypn.entity.Mysf;
import com.ypn.service.Impl.MydjServiceImpl;
import com.ypn.service.Impl.MysfServiceImpl;
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
@WebServlet("/mysf")
public class MysfController extends SystemBaseController {
    MysfServiceImpl mysfService = new MysfServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        resultList = new ArrayList<>();
        Map<String, Object> map = PagesUntil.getPageParams(req);
        String str1Josn = null;
        //获得count(*)、总页数
        int countNum = mysfService.queryCount();
        int countPage = pages.getAllPages(countNum, myPages);
        current = NumberUntil.getIntegerValue(map.get("current"), 1);
        //上一页
        int upIndex = pages.getUp(current);
        //下一页
        int nextIndex = pages.getNext(current, countPage);
        List<Mysf> myHouseList = mysfService.queryLimit(map, null);
        for (int i = 0; i < myHouseList.size(); i++) {
            Mysf mysf = myHouseList.get(i);
            mysf.setAllCount(countNum);
            mysf.setAllPage(countPage);
            mysf.setNext(nextIndex);
            mysf.setUp(upIndex);
            mysf.setCurrent(current);
            resultList.add(mysf);
        }
//        ObjectMapper o = new ObjectMapper();
//        str1Josn= o.writeValueAsString(resultList);
        responseResult(resp,str1Josn);
//        str1Josn = JacksonUntil.obj2Json(resultList);
        //通过response对象将json格式的数据返回给前端的方法
        System.out.println("传入前端的json数据是：" + JacksonUntil.obj2Json(resultList).toString());
//        resp.getWriter().write(str1Josn);
    }
}
