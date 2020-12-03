package com.ypn.until;

import com.ypn.controller.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ypn
 * @date 2020/8/14
 * @motto I raise pigs in your field
 * @desc
 */
public class PagesUntil {
    public static Map<String, Object> getPageParams(HttpServletRequest request) {
        int PageSize = Constants.PAGE_SIZE_DEFAULT;
        int current = 1;//默认是第一页
        String currentPage = request.getParameter("current");//当前页
        Map<String, Object> map = new ConcurrentHashMap<>();
        //如果map没有参数，当不分页处理
//        if (currentPage.isEmpty()){
//            return map;
//        }
        if (!SystemStringUtils.isEmpty(currentPage)) {
            current = NumberUntil.getIntegerValue(currentPage, 1);
        }
        String currentPageSize = request.getParameter("limit");//显示当前显示多少条记录
        if (!SystemStringUtils.isEmpty(currentPageSize)) {
            PageSize = NumberUntil.getIntegerValue(currentPageSize, PageSize);
        }
        //构造分页参数

        map.put("current", current);
        //每页放多少数据
        map.put("PageSize", PageSize);
        //从哪个位置开始取数据
        map.put("start", (current - 1) * PageSize);
        return map;
    }
}
