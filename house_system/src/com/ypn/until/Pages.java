package com.ypn.until;

/**
 * @author ypn
 * @date 2020/8/13
 * @motto I raise pigs in your field
 * @desc
 */
public class Pages {
    /**
     * 所有页数
     *
     * @param countNums 所有数据的count数量
     * @param myPages   每页放多少行数据
     * @return
     */
    public Integer getAllPages(int countNums, int myPages) {
//        DeptServiceImpl deptService = new DeptServiceImpl();
//        countNums = deptService.queryCount("select count(*) from mydept", null);
        int allCount = 0;
        if (myPages != 0) {
            if (countNums % myPages == 0) {
                allCount = countNums / myPages;
            } else {
                allCount = countNums / myPages + 1;
            }
        } else {
            System.out.println("不能除以0，每页必须放数！");
        }
        return allCount;
    }

    /**
     * 上一页
     *
     * @param current 当前页数
     * @return
     */
    public Integer getUp(int current) {
        //如果当前页数-1小于等于0 证明此时就是第一页或第二页
        if (current - 1 <= 0) {
            return 1;
        } else {
            return current - 1;
        }
    }

    /**
     * 下一页
     *
     * @param current 当前页数
     * @param myPages 最大页数
     * @return
     */
    public Integer getNext(int current, int myPages) {
        //如果当前页面+1大于等于myPages  证明此时就是最后一页或倒数第二页
        if (current + 1 >= myPages) {
            return myPages;
        } else {
            return current + 1;
        }
    }

}
