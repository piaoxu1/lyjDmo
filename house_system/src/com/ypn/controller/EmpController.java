package com.ypn.controller;

import com.ypn.entity.Emp;
import com.ypn.service.Impl.EmpServiceImpl;
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
 * @date 2020/8/15
 * @motto I raise pigs in your field
 * @desc
 */
@WebServlet("/emp")
public class EmpController extends SystemBaseController {
    EmpServiceImpl empService = new EmpServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("type");
        if (type.equals("add")) {
            Long jid = Long.valueOf(req.getParameter("emp.myjs.jid"));
            Long pid = Long.valueOf(req.getParameter("emp.mydept.pid"));
            String ename = req.getParameter("emp.ename");
            String psw = req.getParameter("emp.epsw");
            String erelname = req.getParameter("emp.erealname");
            String tel = req.getParameter("emp.etel");
            String eaddress = req.getParameter("emp.eaddress");
            String remark = req.getParameter("emp.eremark");
            Emp emp = new Emp();
            emp.setJID(jid);
            emp.setPID(pid);
            emp.setENAME(ename);
            emp.setEPSW(psw);
            emp.setEREALNAME(erelname);
            emp.setETEL(tel);
            emp.setEADDRESS(eaddress);
            emp.setEREMARK(remark);
            Boolean b = empService.add(emp);
            succss(resp, b);
        }
        if (type.equals("findall")) {
            resultList = new ArrayList<>();
            String strJosn = null;
            Map<String, Object> map = PagesUntil.getPageParams(req);
            //获得count(*)、总页数
            int countNum = empService.queryCount(null);
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"), 1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<Emp> empList = empService.queryLimit(map, null);
            for (int i = 0; i < empList.size(); i++) {
                Emp emp = empList.get(i);
                Emp dto = new Emp();
                dto.setEID(emp.getEID());
                dto.setENAME(emp.getENAME());
                dto.setEPSW(emp.getEPSW());
                dto.setEREALNAME(emp.getEREALNAME());
                dto.setETEL(emp.getETEL());
                dto.setEADDRESS(emp.getEADDRESS());
                dto.setEFLAG(emp.getEFLAG());
                dto.setEREMARK(emp.getEREMARK());
                dto.setPID(emp.getPID());
                dto.setPNAME(emp.getPNAME());
                dto.setJID(emp.getJID());
                dto.setJNAME(emp.getJNAME());
                dto.setAllCount(countNum);
                dto.setAllPage(countPage);
                dto.setNext(nextIndex);
                dto.setUp(upIndex);
                dto.setCurrent(current);
                resultList.add(dto);
            }
            resp.setContentType("application/json;charset=UTF-8");
            //json数据
            strJosn = JacksonUntil.obj2Json(resultList);
            String result = "strJosn" + strJosn;
            System.out.println(result);
            log(result);
            //通过response对象将json格式的数据返回给前端的方法
            resp.getWriter().write(strJosn);
        }

    }
}
