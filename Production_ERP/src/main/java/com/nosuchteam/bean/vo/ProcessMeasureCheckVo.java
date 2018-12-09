package com.nosuchteam.bean.vo;

import java.util.Date;

/**
 * @date 2018/12/9-20:33
 */
public class ProcessMeasureCheckVo {

    private String pMeasureCheckId;

    private String processId;

    private String checkItem;

    private Date cdate;

    private String measureData;

    private String empName;

    private String empId;

    private String result;

    private String note;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public ProcessMeasureCheckVo(String pMeasureCheckId, String processId, String checkItem, Date cdate, String measureData, String empName, String empId, String result, String note) {
        this.pMeasureCheckId = pMeasureCheckId;
        this.processId = processId;
        this.checkItem = checkItem;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empName = empName;
        this.empId = empId;
        this.result = result;
        this.note = note;
    }

    public String getpMeasureCheckId() {
        return pMeasureCheckId;
    }

    public void setpMeasureCheckId(String pMeasureCheckId) {
        this.pMeasureCheckId = pMeasureCheckId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getMeasureData() {
        return measureData;
    }

    public void setMeasureData(String measureData) {
        this.measureData = measureData;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ProcessMeasureCheckVo() {
    }

    public ProcessMeasureCheckVo(String pMeasureCheckId, String processId, String checkItem, Date cdate, String measureData, String empName, String result, String note) {
        this.pMeasureCheckId = pMeasureCheckId;
        this.processId = processId;
        this.checkItem = checkItem;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empName = empName;
        this.result = result;
        this.note = note;
    }
}
