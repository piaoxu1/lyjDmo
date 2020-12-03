package com.ypn.controller;

import com.ypn.until.JacksonUntil;
import com.ypn.until.Pages;
import com.ypn.until.PagesUntil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ypn
 * @date 2020/8/13
 * @motto I raise pigs in your field
 * @desc
 */
public abstract class SystemBaseController extends HttpServlet {
    public static String userName = null;
    protected static final long servalVersionUID = 1L;
    protected int current;//当前页
    protected List resultList;//结果集
    protected int myPages = Constants.PAGE_SIZE_DEFAULT;//每页5条数据
    protected Pages pages = new Pages();//分页对象

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }
    /**
     * 添加回传
     */
 protected  void  succss(HttpServletResponse resp,Boolean type) throws IOException {
     if (type == true) {
         resp.getWriter().write(JacksonUntil.obj2Json(1));
     } else {
         resp.getWriter().write(JacksonUntil.obj2Json(0));
     }
 }
    /**
     * 传入前端的json数据
     * @param resp
     * @param Josn
     * @throws IOException
     */
    protected  void responseResult(HttpServletResponse resp,String Josn) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        //转换为json数据

        Josn = JacksonUntil.obj2Json(resultList);

        //通过response对象将json格式的数据返回给前端的方法
        System.out.println("传入前端的json数据是："+Josn);
        resp.getWriter().write(Josn);
    }

    /**
     * 分页所需要的参数
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    protected Map<String,Object>  currentArgs(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8"); //1
        resultList = new ArrayList<>();
        Map<String,Object> map = PagesUntil.getPageParams(req);
        return map;
    }
}
