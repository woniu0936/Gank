package com.woniu.gank.data.bean;

/**
 * @author woniu
 * @title Paginator
 * @description 分页实体类
 * @modifier
 * @date
 * @since 16/10/25 下午12:46
 */

public class Paginator {

    private int pageNo;
    private int pageSize;

    public Paginator() {
        pageNo = 1;
        pageSize = 20;
    }

    public Paginator(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
