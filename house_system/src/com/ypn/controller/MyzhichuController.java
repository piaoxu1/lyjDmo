package com.ypn.controller;

import com.ypn.entity.Myshouru;
import com.ypn.entity.Myzhichu;
import com.ypn.service.Impl.MyshouruServiceImpl;
import com.ypn.service.Impl.MyzhichuServiceImpl;
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
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc 日常房屋支出信息控制层
 */
@WebServlet("/myzhichu")
public class MyzhichuController extends  SystemBaseController {
    MyzhichuServiceImpl myzhichuService = new MyzhichuServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //1
        String type = req.getParameter("type");
        if (type.equals("add")){
            String money = req.getParameter("zc.zmoney");
            String tm = req.getParameter("zc.ztm");
            String remark = req.getParameter("zc.zremark");
            Myzhichu myzhichu = new Myzhichu();
            myzhichu.setZmoney(Float.valueOf(money));
            myzhichu.setZremark(remark);
            myzhichu.setZtm(tm);
            Boolean sta = myzhichuService.add(myzhichu);
            succss(resp, sta);
        }
        if (type.equals("findall")){
            resultList = new ArrayList<>();
            Map<String, Object> map = PagesUntil.getPageParams(req);
            String str1Josn = null;
            //获得count(*)、总页数
            int countNum = myzhichuService.queryCount();
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"), 1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<Myzhichu> myHouseList = null;
            try {
                myHouseList = myzhichuService.query(null, map);
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
                Myzhichu myzhichu = myHouseList.get(i);
                myzhichu.setAllCount(countNum);
                myzhichu.setAllPage(countPage);
                myzhichu.setNext(nextIndex);
                myzhichu.setUp(upIndex);
                myzhichu.setCurrent(current);
                resultList.add(myzhichu);
            }
            responseResult(resp, str1Josn);
            System.out.println("传入前端的json数据是：" + JacksonUntil.obj2Json(resultList));
        }
        }

}
