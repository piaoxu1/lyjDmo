package com.ypn.test;

import com.ypn.controller.SystemBaseController;
import com.ypn.service.Impl.SortServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ypn
 * @date 2020/8/19
 * @motto I raise pigs in your field
 * @desc
 */
@WebServlet("/testAdd")
public class TestAdd extends SystemBaseController {
    SortServiceImpl sortService = new SortServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        //设置编码格式
        req.setCharacterEncoding("UTF-8"); //1
        resp.setContentType("text/html;charset=utf-8"); //2
        resp.setCharacterEncoding("utf-8"); //3
        String Sname= req.getParameter("sort.sname");
//        sortService.addSort(Sname);
    }
}
