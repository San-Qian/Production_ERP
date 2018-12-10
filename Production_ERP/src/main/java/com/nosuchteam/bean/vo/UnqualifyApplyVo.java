package com.nosuchteam.bean.vo;

import com.nosuchteam.bean.UnqualifyApply;

import java.util.Date;

/**
 * @date 2018/12/7-9:55
 */
public class UnqualifyApplyVo extends UnqualifyApply {
    private String unqualifyApplyId;

    private String productId;

    private String unqualifyItem;

    private Integer unqualifyCount;

    private Date assemblyDate;

    private String empId;

    private Date applyDate;

    private String note;

    private String empName;

    private String productName;

    @Override
    public String toString() {
        return "UnqualifyApplyVo{" +
                "unqualifyApplyId='" + unqualifyApplyId + '\'' +
                ", productId='" + productId + '\'' +
                ", unqualifyItem='" + unqualifyItem + '\'' +
                ", unqualifyCount=" + unqualifyCount +
                ", assemblyDate=" + assemblyDate +
                ", empId='" + empId + '\'' +
                ", applyDate=" + applyDate +
                ", note='" + note + '\'' +
                ", empName='" + empName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }

    @Override
    public String getUnqualifyApplyId() {
        return unqualifyApplyId;
    }

    @Override
    public void setUnqualifyApplyId(String unqualifyApplyId) {
        this.unqualifyApplyId = unqualifyApplyId;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String getUnqualifyItem() {
        return unqualifyItem;
    }

    @Override
    public void setUnqualifyItem(String unqualifyItem) {
        this.unqualifyItem = unqualifyItem;
    }

    @Override
    public Integer getUnqualifyCount() {
        return unqualifyCount;
    }

    @Override
    public void setUnqualifyCount(Integer unqualifyCount) {
        this.unqualifyCount = unqualifyCount;
    }

    @Override
    public Date getAssemblyDate() {
        return assemblyDate;
    }

    @Override
    public void setAssemblyDate(Date assemblyDate) {
        this.assemblyDate = assemblyDate;
    }

    @Override
    public String getEmpId() {
        return empId;
    }

    @Override
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public Date getApplyDate() {
        return applyDate;
    }

    @Override
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public UnqualifyApplyVo() {
    }

    public UnqualifyApplyVo(String unqualifyApplyId, String productId, String unqualifyItem, Integer unqualifyCount, Date assemblyDate, String empId, Date applyDate, String note, String empName, String productName) {
        this.unqualifyApplyId = unqualifyApplyId;
        this.productId = productId;
        this.unqualifyItem = unqualifyItem;
        this.unqualifyCount = unqualifyCount;
        this.assemblyDate = assemblyDate;
        this.empId = empId;
        this.applyDate = applyDate;
        this.note = note;
        this.empName = empName;
        this.productName = productName;
    }
}