package com.nosuchteam.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

public class Task {
    private String taskId;

    private Manufacture manufacture;
    private String manufactureSn;

    private Work work;
    private String workId;

    private Integer taskQuantity;

    private Long workingHours;

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", manufacture=" + manufacture +
                ", manufactureSn='" + manufactureSn + '\'' +
                ", work=" + work +
                ", workId='" + workId + '\'' +
                ", taskQuantity=" + taskQuantity +
                ", workingHours=" + workingHours +
                '}';
    }

    public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Integer getTaskQuantity() {
        return taskQuantity;
    }

    public void setTaskQuantity(Integer taskQuantity) {
        this.taskQuantity = taskQuantity;
    }

    public Long getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Long workingHours) {
        this.workingHours = workingHours;
    }
}