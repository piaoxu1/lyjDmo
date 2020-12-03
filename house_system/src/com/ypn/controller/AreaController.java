package com.ypn.controller;

import com.ypn.entity.Area;
import com.ypn.entity.Sort;
import com.ypn.service.Impl.AreaServiceImpl;
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
 * @date 2020/8/16
 * @motto I raise pigs in your field
 * @desc
 */
@WebServlet("/area")
public class AreaController extends SystemBaseController{
    AreaServiceImpl areaService = new AreaServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String str= req.getParameter("type");
        if(str.equals("add")){
          String name =  req.getParameter("area.aname");
            Object[] objects = {name};
            boolean type =areaService.add(objects);
            succss(resp,type);
        }
        if (str.equals("findall")){
            resultList = new ArrayList<>();
            String strJosn = null;
            Map<String,Object> map = PagesUntil.getPageParams(req);
            //获得count(*)、总页数
            int countNum = areaService.queryCount(null);
            int countPage = pages.getAllPages(countNum, myPages);
            current = NumberUntil.getIntegerValue(map.get("current"),1);
            //上一页
            int upIndex = pages.getUp(current);
            //下一页
            int nextIndex = pages.getNext(current, countPage);

            List<Area> areas = areaService.queryLimit(map,null);
            for (int i = 0; i < areas.size(); i++) {
                Area area = areas.get(i);
                Area dto = new Area();
                dto.setAID(area.getAID());
                dto.setANAME(area.getANAME());
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
