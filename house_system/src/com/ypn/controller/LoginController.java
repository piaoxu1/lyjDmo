package com.ypn.controller;

import com.ypn.entity.Emp;
import com.ypn.service.Impl.EmpServiceImpl;
import com.ypn.until.JacksonUntil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ypn
 * @date 2020/8/23
 * @motto I raise pigs in your field
 * @desc 登录验证   修改密码
 */
@WebServlet("/login")
public class LoginController extends SystemBaseController {
    EmpServiceImpl empService = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String str = req.getParameter("type");
//        HttpSession session = req.getSession();
        //修改密码验证是否是该密码
        if (str.equals("havapsw")) {
            String sqlpwd = "";
            Object[] objects = {userName};
            System.out.println(userName);
            sqlpwd = empService.selectPwd(objects);
            System.out.println(sqlpwd);
            resp.getWriter().write(JacksonUntil.obj2Json(sqlpwd));
        }
        //修改密码
        if (str.equals("update")) {
            String newpsw = req.getParameter("psw").trim();
            System.out.println(newpsw);
            Object[] objects = {newpsw, userName};
            boolean sta = empService.update(objects);
            if (sta == true) {
                resp.getWriter().write(JacksonUntil.obj2Json(1));
            } else {
                resp.getWriter().write(JacksonUntil.obj2Json(0));
            }

        }
        //判断是否存在此用户名
        if (str.equals("user")) {
            String user = req.getParameter("ename");
            Object[] o = {user};
            String pwd = empService.selectPwd(o);
            if (pwd.length() == 0 && pwd.isEmpty()) {
                resp.getWriter().write(JacksonUntil.obj2Json(0));
            } else {
                resp.getWriter().write(JacksonUntil.obj2Json(1));
            }
        }
        //判断密码是否正确
        if (str.equals("login")) {
            String user = req.getParameter("emp.ename").trim();
            String pwd = req.getParameter("emp.epsw").trim();
            List<Emp> list = empService.queryListTodto(null);
            int type = 0;
            for (int i = 0; i < list.size(); i++) {
                String emp = list.get(i).getENAME().trim();
                String epwd = list.get(i).getEPSW().trim();
                if (emp.equals(user)) {//证明这个账号存在
                    if (epwd.equals(pwd)) {//验证密码
                        userName = emp;
//                        session.setAttribute("userName",userName);
                        type = 1;
                        break;
                    }
                }
            }
            resp.getWriter().append(JacksonUntil.obj2Json(type));
        }

    }
}
