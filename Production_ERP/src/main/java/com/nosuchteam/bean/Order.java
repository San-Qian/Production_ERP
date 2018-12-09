package com.nosuchteam.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class Order {
    @Pattern(regexp = "[0-9a-zA-Z]+", message = "请输入数字或英文字母的组合")
    @Length(min = 3,max = 8,message = "请输入3-8位合法编号")
    private String orderId;

    private Custom custom;
    private String customId;

    private Product product;
    private String productId;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date requestDate;

    private String note;

    @Min(value = 0,message = "请输入正确的订购数量")
    private Integer quantity;

    private BigDecimal unitPrice;

    @Pattern(regexp = "[\u4e00-\u9fa5a-zA-Z]+",message = "请输入正确的单位")
    private String unit;

    private String image;

    private String file;

    @Min(value = 1,message = "状态异常")
    @Max(value = 4,message = "状态异常")
    private Integer status;


    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", custom=" + custom +
                ", customId='" + customId + '\'' +
                ", product=" + product +
                ", productId='" + productId + '\'' +
                ", orderDate=" + orderDate +
                ", requestDate=" + requestDate +
                ", note='" + note + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", unit='" + unit + '\'' +
                ", image='" + image + '\'' +
                ", file='" + file + '\'' +
                ", status=" + status +
                '}';
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}