package com.ypn.service;

import com.ypn.entity.MyHouse;

import java.util.List;
import java.util.Map;

public interface ServiceDao{
    Integer queryCount();
    List queryLimit(Map<String, Object> pageMap, Object[] objects);
    List<Map<String, Object>> queryRecords(Object[] objects);
}
