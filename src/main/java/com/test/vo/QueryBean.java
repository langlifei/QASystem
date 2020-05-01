package com.test.vo;

public class QueryBean {
    private Object data;
    private Integer total;
    private Integer pageSize;
    private Integer current;

    public QueryBean(Object data, Integer total, Integer pageSize, Integer current) {
        this.data = data;
        this.total = total;
        this.pageSize = pageSize;
        this.current = current;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
