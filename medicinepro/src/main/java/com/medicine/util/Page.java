package com.medicine.util;

/**
 * @Auther: 刘涵
 * @Date: 2019/11/19 0019 20:25
 * @Description:
 */
public class Page<T> {
    //当前页
    private Integer page=1;
    //页大小
    private Integer limit=10;
    // 总条数
    private Integer totalRecord;
    //总页数
    private Integer totalPage;
    //传递条件
    private T t;

    public Page() {
    }

    public Page(Integer page, Integer limit, Integer totalRecord, Integer totalPage, T t) {
        this.page = page;
        this.limit = limit;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.t = t;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getlimit() {
        return limit;
    }

    public void setlimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
