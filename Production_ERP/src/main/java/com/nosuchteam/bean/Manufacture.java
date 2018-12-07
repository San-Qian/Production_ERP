package com.nosuchteam.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class Manufacture {
    @Pattern(regexp = "[0-9a-zA-Z]+", message = "请输入数字或英文字母的组合")
    @Length(min = 3,max = 8,message = "请输入3-8位合法编号")
    private String manufactureSn;

    private Order cOrder;
    private String orderId;

    private Technology technology;
    private String technologyId;

    private Integer launchQuantity;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @Override
    public String toString() {
        return "Manufacture{" +
                "manufactureSn='" + manufactureSn + '\'' +
                ", cOrder=" + cOrder +
                ", orderId='" + orderId + '\'' +
                ", technology=" + technology +
                ", technologyId='" + technologyId + '\'' +
                ", launchQuantity=" + launchQuantity +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn;
    }

    public Order getcOrder() {
        return cOrder;
    }

    public void setcOrder(Order cOrder) {
        this.cOrder = cOrder;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public Integer getLaunchQuantity() {
        return launchQuantity;
    }

    public void setLaunchQuantity(Integer launchQuantity) {
        this.launchQuantity = launchQuantity;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}