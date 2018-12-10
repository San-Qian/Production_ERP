package com.nosuchteam.bean.vo;

import com.nosuchteam.bean.FinalMeasuretCheck;

import java.util.Date;

/**
 * @date 2018/12/9-17:28
 */
public class FinalMeasuretCheckVo extends FinalMeasuretCheck {
    private String fMeasureCheckId;

    private String orderId;

    private String checkItem;

    private Date cdate;

    private String measureData;

    private String empName;

    private String empId;

    private String result;

    private String note;

    @Override
    public String getEmpId() {
        return empId;
    }

    @Override
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public FinalMeasuretCheckVo(String fMeasureCheckId, String orderId, String checkItem, Date cdate, String measureData, String empName, String empId, String result, String note) {
        this.fMeasureCheckId = fMeasureCheckId;
        this.orderId = orderId;
        this.checkItem = checkItem;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empName = empName;
        this.empId = empId;
        this.result = result;
        this.note = note;
    }

    @Override
    public String getfMeasureCheckId() {
        return fMeasureCheckId;
    }

    @Override
    public void setfMeasureCheckId(String fMeasureCheckId) {
        this.fMeasureCheckId = fMeasureCheckId;
    }

    @Override
    public String getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String getCheckItem() {
        return checkItem;
    }

    @Override
    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    @Override
    public Date getCdate() {
        return cdate;
    }

    @Override
    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    @Override
    public String getMeasureData() {
        return measureData;
    }

    @Override
    public void setMeasureData(String measureData) {
        this.measureData = measureData;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    public FinalMeasuretCheckVo() {
    }

    public FinalMeasuretCheckVo(String fMeasureCheckId, String orderId, String checkItem, Date cdate, String measureData, String empName, String result, String note) {
        this.fMeasureCheckId = fMeasureCheckId;
        this.orderId = orderId;
        this.checkItem = checkItem;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empName = empName;
        this.result = result;
        this.note = note;
    }
}
