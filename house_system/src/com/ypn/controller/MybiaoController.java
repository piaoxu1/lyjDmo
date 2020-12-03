package com.ypn.controller;

import com.ypn.entity.Mybiao;
import com.ypn.entity.Mysf;
import com.ypn.service.Impl.MybiaoServiceImpl;
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
 * @desc 操表记录信息表
 */
@WebServlet("/mybiao")
public class MybiaoController extends SystemBaseController {
    MybiaoServiceImpl mybiaoService = new MybiaoServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        String type =req.getParameter("type");
        if (type.equals("add")){
            String skd=req.getParameter("biao.skd");
            String dkd=req.getParameter("biao.dkd");
            String mkd=req.getParameter("biao.mkd");
            String hid=req.getParameter("biao.hid");
            Object[] objects ={hid,dkd,skd,mkd};
           Boolean b=  mybiaoService.add(objects);
           succss(resp,b);
        }
        if (type.equals("findall")){
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
            List<Mybiao> myHouseList = mybiaoService.queryLimit(map, null);
            for (int i = 0; i < myHouseList.size(); i++) {
                Mybiao mysf = myHouseList.get(i);
                mysf.setAllCount(countNum);
                mysf.setAllPage(countPage);
                mysf.setNext(nextIndex);
                mysf.setUp(upIndex);
                mysf.setCurrent(current);
                resultList.add(mysf);
            }
            responseResult(resp,str1Josn);
            //通过response对象将json格式的数据返回给前端的方法
            System.out.println("传入前端的json数据是：" + JacksonUntil.obj2Json(resultList).toString());
        }

    }
}
