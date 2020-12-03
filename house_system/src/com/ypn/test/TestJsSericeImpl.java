package com.ypn.test;

import com.ypn.entity.Js;
import com.ypn.service.Impl.JsServiceImpl;

import java.util.List;

/**
 * @author ypn
 * @date 2020/8/15
 * @motto I raise pigs in your field
 * @desc 测试JsSericeImpl
 */
public class TestJsSericeImpl {
    public static void main(String[] args) {
        JsServiceImpl js = new JsServiceImpl();
        Object[] o  = new Object[]{};
        //测试添加
//        Object[] add  ={3,"经理"};
//        js.add(add);
        //测试修改
//        Object[] update ={3,"董事长",3};
//        js.update(update);
        //测试删除
//        Object[] delete={3};
//        js.delete(delete);
        //测试查询
        System.out.println(js.queryRecords(o).toString());
        //测试查询count
        System.out.println(js.queryCount(null));
        //测试
        System.out.println(js.queryListTodto(null).toString());
    }
}
