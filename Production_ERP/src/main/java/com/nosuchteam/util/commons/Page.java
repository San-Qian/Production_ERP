package com.nosuchteam.util.commons;

import java.util.List;

/**
 * @Author: Evan
 * @Date: 2018/12/5 17:40
 * @Description:
 */
public class Page {
    private int total;
    private List rows;

    public Page() {
    }

    public Page(int total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total='" + total + '\'' +
                ", rows=" + rows +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
