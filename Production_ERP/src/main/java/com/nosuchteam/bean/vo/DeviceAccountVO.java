package com.nosuchteam.bean.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: SanQian
 * @create: 2018-12-06 17:36
 */
public class DeviceAccountVO {

    private String deviceId;
    private String deviceName;
    private String deviceTypeId;
    private String deviceStatusId;
    private String deviceStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date devicePurchaseDate;
    private String devicePurchasePrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deviceManufactureDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deviceServiceLife;
    private String deviceKeeperId;
    private String note;
    private String deviceIdd;
    private String deviceTypeName;
    private String deviceKeeper;

    @Override
    public String toString() {
        return "DeviceAccountVO{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceTypeId='" + deviceTypeId + '\'' +
                ", deviceStatusId='" + deviceStatusId + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", devicePurchaseDate=" + devicePurchaseDate +
                ", devicePurchasePrice='" + devicePurchasePrice + '\'' +
                ", deviceManufactureDate=" + deviceManufactureDate +
                ", deviceServiceLife=" + deviceServiceLife +
                ", deviceKeeperId='" + deviceKeeperId + '\'' +
                ", note='" + note + '\'' +
                ", deviceIdd='" + deviceIdd + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceKeeper='" + deviceKeeper + '\'' +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceStatusId() {
        return deviceStatusId;
    }

    public void setDeviceStatusId(String deviceStatusId) {
        this.deviceStatusId = deviceStatusId;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Date getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(Date devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public String getDevicePurchasePrice() {
        return devicePurchasePrice;
    }

    public void setDevicePurchasePrice(String devicePurchasePrice) {
        this.devicePurchasePrice = devicePurchasePrice;
    }

    public Date getDeviceManufactureDate() {
        return deviceManufactureDate;
    }

    public void setDeviceManufactureDate(Date deviceManufactureDate) {
        this.deviceManufactureDate = deviceManufactureDate;
    }

    public Date getDeviceServiceLife() {
        return deviceServiceLife;
    }

    public void setDeviceServiceLife(Date deviceServiceLife) {
        this.deviceServiceLife = deviceServiceLife;
    }

    public String getDeviceKeeperId() {
        return deviceKeeperId;
    }

    public void setDeviceKeeperId(String deviceKeeperId) {
        this.deviceKeeperId = deviceKeeperId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDeviceIdd() {
        return deviceIdd;
    }

    public void setDeviceIdd(String deviceIdd) {
        this.deviceIdd = deviceIdd;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }
}
