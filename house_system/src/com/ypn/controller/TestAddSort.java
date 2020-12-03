package com.ypn.controller;

import com.ypn.service.Impl.SortServiceImpl;
import com.ypn.until.JacksonUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ypn
 * @date 2020/8/20
 * @motto I raise pigs in your field
 * @desc
 */
@WebServlet("/addSort")
public class TestAddSort extends HttpServlet {
    SortServiceImpl sortService = new SortServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8"); //1
//        String name = req.getParameter("sort.sname");
//        boolean type = sortService.addSort(name);
//        if (type == true) {
//            resp.getWriter().write(JacksonUntil.obj2Json(1));
//        } else {
//            resp.getWriter().write(JacksonUntil.obj2Json(0));
//        }
//
//    }
}
