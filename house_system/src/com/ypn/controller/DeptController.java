package com.ypn.controller;


import com.ypn.entity.Dept;
import com.ypn.service.Impl.DeptServiceImpl;
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
import java.util.logging.Logger;

/**
 * @author ypn
 * @date 2020/8/13
 * @motto I raise pigs in your field
 * @desc
 */
@WebServlet("/dept")
public class DeptController extends SystemBaseController {
    private DeptServiceImpl deptServiceImpl = new DeptServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String str= req.getParameter("type");
        if(str.equals("add")){
            String name = req.getParameter("dept.pname");
            String remark=req.getParameter("dept.premark");
            Object[] objects ={name,remark};
            Boolean type = deptServiceImpl.add(objects);
            if (type == true) {
                resp.getWriter().write(JacksonUntil.obj2Json(1));
            } else {
                resp.getWriter().write(JacksonUntil.obj2Json(0));
            }
        }
        if (str.equals("findall")){
            resultList = new ArrayList<>();
            String strJosn = null;
            Map<String,Object> map = PagesUntil.getPageParams(req);
            System.out.println("map获取到的数据为："+ map.get("current")+"\r"+map.get("PageSize")+"\r"+map.get("start"));
            //获得count(*)、总页数
            int countNum = deptServiceImpl.queryCount( null);
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"),1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);
            List<Dept> deptList = deptServiceImpl.queryLimit(map,null);
            for (int i = 0; i < deptList.size(); i++) {
                Dept dept = deptList.get(i);
                Dept dto = new Dept();
                dto.setPID(dept.getPID());
                dto.setPNAME(dept.getPNAME());
                dto.setPFLAG(dept.getPFLAG());
                dto.setPREMARK(dept.getPREMARK());
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
//            log(result);
            //通过response对象将json格式的数据返回给前端的方法
            resp.getWriter().write(strJosn);
        }

    }

}
