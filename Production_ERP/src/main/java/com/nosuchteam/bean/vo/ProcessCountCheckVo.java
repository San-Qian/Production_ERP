package com.nosuchteam.bean.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @date 2018/12/9-21:04
 */
public class ProcessCountCheckVo {

    private String pCountCheckId;

    private String processId;

    private String checkItem;

    private Integer sample;

    private Integer checkNumber;

    private Integer unqualify;

    private BigDecimal qualify;

    private Date cdate;

    private String measureData;

    private String empName;

    private String result;

    private String note;

    @Override
    public String toString() {
        return "ProcessCountCheckVo{" +
                "pCountCheckId='" + pCountCheckId + '\'' +
                ", processId='" + processId + '\'' +
                ", checkItem='" + checkItem + '\'' +
                ", sample=" + sample +
                ", checkNumber=" + checkNumber +
                ", unqualify=" + unqualify +
                ", qualify=" + qualify +
                ", cdate=" + cdate +
                ", measureData='" + measureData + '\'' +
                ", empName='" + empName + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getpCountCheckId() {
        return pCountCheckId;
    }

    public void setpCountCheckId(String pCountCheckId) {
        this.pCountCheckId = pCountCheckId;
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

    public Integer getSample() {
        return sample;
    }

    public void setSample(Integer sample) {
        this.sample = sample;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Integer getUnqualify() {
        return unqualify;
    }

    public void setUnqualify(Integer unqualify) {
        this.unqualify = unqualify;
    }

    public BigDecimal getQualify() {
        return qualify;
    }

    public void setQualify(BigDecimal qualify) {
        this.qualify = qualify;
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

    public ProcessCountCheckVo() {
    }

    public ProcessCountCheckVo(String pCountCheckId, String processId, String checkItem, Integer sample, Integer checkNumber, Integer unqualify, BigDecimal qualify, Date cdate, String measureData, String empName, String result, String note) {
        this.pCountCheckId = pCountCheckId;
        this.processId = processId;
        this.checkItem = checkItem;
        this.sample = sample;
        this.checkNumber = checkNumber;
        this.unqualify = unqualify;
        this.qualify = qualify;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empName = empName;
        this.result = result;
        this.note = note;
    }
}
