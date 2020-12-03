package com.ypn.entity;

/**
 * @author ypn
 * @date 2020/8/19
 * @motto I raise pigs in your field
 * @desc
 */
public abstract class BaseDto{
    protected Integer AllCount;//所有结果数
    protected Integer AllPage;//所有页数
    protected Integer current;//当前页数
    protected Integer up;
    protected Integer next;

    public Integer getAllCount() {
        return AllCount;
    }

    public void setAllCount(Integer allCount) {
        AllCount = allCount;
    }

    public Integer getAllPage() {
        return AllPage;
    }

    public void setAllPage(Integer allPage) {
        AllPage = allPage;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }
}
