package com.nosuchteam.bean;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class Work {
    @Pattern(regexp = "[0-9a-zA-Z]+", message = "请输入数字或英文字母的组合")
    @Length(min = 3,max = 8,message = "请输入3-8位合法编号")
    private String workId;
    private String processNumber;

    private Product product;
    private String productId;

    private Process process;
    private String processId;

    private Device device;
    private String deviceId;

    @Min(value = 0,message = "请输入正确的班产定额")
    private Integer rating;

    @Override
    public String toString() {
        return "Work{" +
                "workId='" + workId + '\'' +
                ", processNumber='" + processNumber + '\'' +
                ", product=" + product +
                ", productId='" + productId + '\'' +
                ", process=" + process +
                ", processId='" + processId + '\'' +
                ", device=" + device +
                ", deviceID='" + deviceId + '\'' +
                ", rating=" + rating +
                '}';
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}