package com.nosuchteam.bean.vo;

import com.nosuchteam.bean.FinalCountCheck;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @date 2018/12/9-20:02
 */
public class FinalCountCheckVo extends FinalCountCheck {
    private String fCountCheckId;

    private String orderId;

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
        return "FinalCountCheckVo{" +
                "fCountCheckId='" + fCountCheckId + '\'' +
                ", orderId='" + orderId + '\'' +
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

    @Override
    public String getfCountCheckId() {
        return fCountCheckId;
    }

    @Override
    public void setfCountCheckId(String fCountCheckId) {
        this.fCountCheckId = fCountCheckId;
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
    public Integer getSample() {
        return sample;
    }

    @Override
    public void setSample(Integer sample) {
        this.sample = sample;
    }

    @Override
    public Integer getCheckNumber() {
        return checkNumber;
    }

    @Override
    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public Integer getUnqualify() {
        return unqualify;
    }

    @Override
    public void setUnqualify(Integer unqualify) {
        this.unqualify = unqualify;
    }

    @Override
    public BigDecimal getQualify() {
        return qualify;
    }

    @Override
    public void setQualify(BigDecimal qualify) {
        this.qualify = qualify;
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

    public FinalCountCheckVo() {
    }

    public FinalCountCheckVo(String fCountCheckId, String orderId, String checkItem, Integer sample, Integer checkNumber, Integer unqualify, BigDecimal qualify, Date cdate, String measureData, String empName, String result, String note) {
        this.fCountCheckId = fCountCheckId;
        this.orderId = orderId;
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
