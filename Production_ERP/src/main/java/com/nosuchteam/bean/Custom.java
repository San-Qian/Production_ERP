package com.nosuchteam.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class Custom {
    @Pattern(regexp = "[0-9a-zA-Z]+", message = "请输入数字或英文字母的组合")
    @Length(min = 3,max = 8,message = "请输入3-8位合法编号")
    private String customId;
    @NotNull(message = "请输入客户名称")
    private String customName;
    private String fullName;

    private String address;
    @Pattern(regexp = "((\\d{3,4}-)?\\d{7,8})?",message = "请输入正确的传真号码")
    private String fax;

    @Email(message = "请输入正确的邮箱格式")
    private String email;

    private String ownerName;
    @Pattern(regexp = "[+]?(\\d){1,3}[ ]?([-]?((\\d)|[ ]){1,12})+",message = "请输入正确的手机号码")
    private String ownerTel;
    @Min(value = 1,message = "状态异常")
    @Max(value = 2,message = "状态异常")
    private Integer status;

    private String note;

    @Override
    public String toString() {
        return "Custom{" +
                "customId='" + customId + '\'' +
                ", customName='" + customName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerTel='" + ownerTel + '\'' +
                ", status=" + status +
                ", note='" + note + '\'' +
                '}';
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId == null ? null : customId.trim();
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel == null ? null : ownerTel.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}