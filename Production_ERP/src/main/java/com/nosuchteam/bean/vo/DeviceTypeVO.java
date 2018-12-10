package com.nosuchteam.bean.vo;

import com.nosuchteam.bean.DeviceType;

import java.util.List;

/**
 * @author: SanQian
 * @create: 2018-12-06 20:18
 */
public class DeviceTypeVO {
    private int total;
    private List<DeviceType> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DeviceType> getRows() {
        return rows;
    }

    public void setRows(List<DeviceType> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DeviceTypeVO{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
