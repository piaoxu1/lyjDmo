package com.ypn.test;

import com.ypn.dao.impl.SortDaoImpl;
import com.ypn.service.Impl.DeptServiceImpl;
import com.ypn.service.Impl.SortServiceImpl;

/**
 * @author ypn
 * @date 2020/8/16
 * @motto I raise pigs in your field
 * @desc
 */
public class TestSortService {
    public static void main(String[] args) {
        //测试查询所有
        SortServiceImpl sortService = new SortServiceImpl();
        System.out.println(sortService.queryRecords(null).toString());
        //查询count(*)
        System.out.println(sortService.queryCount());
        System.out.println(sortService.queryRecords(null));
    }
}
