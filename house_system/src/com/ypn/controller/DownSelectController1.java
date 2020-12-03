package com.ypn.controller;

import com.ypn.entity.MyHouse;
import com.ypn.service.Impl.MyHouseServiceImpl;
import com.ypn.service.Impl.MyHouseServiceImpl1;
import com.ypn.until.NumberUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/27
 * @motto I raise pigs in your field
 * @desc 第一个下拉框筛选查询(出租房分类查询)
 */
@WebServlet("/downselect1")
public class DownSelectController1 extends SystemBaseController {
    MyHouseServiceImpl1 myHouseService = new MyHouseServiceImpl1();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aid = req.getParameter("aid").trim();
        String sid = req.getParameter("sid").trim();
        String zt = req.getParameter("zt").trim();
        Map<String, Object> map = currentArgs(req);
        //查询全部
        Object[] objects = {zt, Integer.parseInt(sid), Integer.parseInt(aid)};
        try {
            resultList = myHouseService.screen(objects, map);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String strJosn = null;
        responseResult(resp, strJosn);
    }



}
