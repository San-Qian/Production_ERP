package com.nosuchteam.bean.vo;

import java.util.List;

/**
 * @author: SanQian
 * @create: 2018-12-06 17:35
 */
public class DeviceAccountListVO {
    private int total;
    private List<DeviceAccountVO> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DeviceAccountVO> getRows() {
        return rows;
    }

    public void setRows(List<DeviceAccountVO> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DeviceAccountListVO{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
